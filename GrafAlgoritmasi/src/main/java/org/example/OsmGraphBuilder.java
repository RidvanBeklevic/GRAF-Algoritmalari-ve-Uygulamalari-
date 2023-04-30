package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import java.util.HashMap;
import java.util.Map;

public class OsmGraphBuilder {
    private static final double EARTH_RADIUS = 6371; // km

    public static Graph<String, DefaultWeightedEdge> buildGraph(JsonNode osmData) {
        Graph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        Map<String, double[]> nodeIdToCoordinates = new HashMap<>();

        for (JsonNode node : osmData.get("elements")) {
            if (node.get("type").asText().equals("node")) {
                String nodeId = node.get("id").asText();
                double lat = node.get("lat").asDouble();
                double lon = node.get("lon").asDouble();
                nodeIdToCoordinates.put(nodeId, new double[]{lat, lon});
                graph.addVertex(nodeId);
            }
        }

        for (JsonNode way : osmData.get("elements")) {
            if (way.get("type").asText().equals("way")) {
                JsonNode nodes = way.get("nodes");
                for (int i = 0; i < nodes.size() - 1; i++) {
                    String fromNodeId = nodes.get(i).asText();
                    String toNodeId = nodes.get(i + 1).asText();
                    DefaultWeightedEdge edge = graph.addEdge(fromNodeId, toNodeId);
                    if (edge != null) {
                        double distance = distanceBetweenNodes(nodeIdToCoordinates, fromNodeId, toNodeId);
                        graph.setEdgeWeight(edge, distance);
                    }
                }
            }
        }

        return graph;
    }

    private static double distanceBetweenNodes(Map<String, double[]> nodeIdToCoordinates, String fromNodeId, String toNodeId) {
        double[] fromCoordinates = nodeIdToCoordinates.get(fromNodeId);
        double[] toCoordinates = nodeIdToCoordinates.get(toNodeId);

        double lat1 = Math.toRadians(fromCoordinates[0]);
        double lon1 = Math.toRadians(fromCoordinates[1]);
        double lat2 = Math.toRadians(toCoordinates[0]);
        double lon2 = Math.toRadians(toCoordinates[1]);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c * 1000; // m
    }
}
