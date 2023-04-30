package org.example;

import java.io.IOException;
import java.util.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.alg.shortestpath.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DroneDelivery {
    public static void main(String[] args) throws IOException {
        // Belirli bir konum ve yarıçap için harita verisi çekme
        double latitude = 39.9208; // Ankara, Türkiye
        double longitude = 32.8541;
        double radius = 1500; // 1.5 km yarıçap

        // OpenStreetMap API'sini kullanarak veri alın
        String overpassApiUrl = "http://overpass-api.de/api/interpreter";
        String query = String.format(Locale.ENGLISH, "[out:json][timeout:180];(way[\"highway\"](around:%f,%f,%f););out body;>;out skel qt;", radius, latitude, longitude);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode response = objectMapper.readTree(Utils.getHttpResponse(overpassApiUrl, query));

        // Verileri JGraphT grafiğine dönüştürün
        Graph<String, DefaultWeightedEdge> graph = OsmGraphBuilder.buildGraph(response);

        // Noktaların belirlenmesi
        int numPoints = 10;
        List<String> points = Utils.sampleNodes(graph.vertexSet(), numPoints);

        // İhtiyaçları ve stokları belirleme
        List<int[]> needs = generatePriorityNeeds(numPoints);
        int[] stocks = {100, 100, 70, 70};

        // İhtiyaçlara göre dağıtım planı oluşturma
        List<int[]> plan = distributionPlan(points, needs, stocks);

        // Drone rotası oluşturma
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);


        // Dağıtım noktaları arasında en kısa yol bulma
        List<List<String>> shortestPaths = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            GraphPath<String, DefaultWeightedEdge> path = dijkstra.getPath(points.get(i), points.get(i + 1));
            if (path != null) {
                shortestPaths.add(path.getVertexList());
                System.out.printf("Nokta %d -> Nokta %d:%n", i + 1, i + 2);
                System.out.println(shortestPaths.get(i));
                System.out.println();
            } else {
                System.out.printf("Nokta %d ve Nokta %d arasında geçerli bir yol bulunamadı.%n", i + 1, i + 2);
            }
        }


    }

    // Öncelikli ihtiyaçları üreten fonksiyon
    public static List<int[]> generatePriorityNeeds(int numPoints) {
        List<int[]> needs = new ArrayList<>();
        for (int i = 0; i < numPoints; i++) {
            int[] need = {
                    Utils.randomInt(15, 30), // Sağlık Malzemesi
                    Utils.randomInt(10, 25), // Temel Gıda
                    Utils.randomInt(5, 20),  // Isınma Gereci
                    Utils.randomInt(5, 15)   // Giyecek
            };
            needs.add(need);
        }
        return needs;
    }

    public static List<int[]> distributionPlan(List<String> points, List<int[]> needs, int[] stocks) {
        List<int[]> plan = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            int[] stockRequired = new int[stocks.length];
            for (int j = 0; j < stocks.length; j++) {
                stockRequired[j] = Math.min(stocks[j], needs.get(i)[j]);
                stocks[j] -= stockRequired[j];
            }
            plan.add(stockRequired);
        }
        return plan;
    }
}
