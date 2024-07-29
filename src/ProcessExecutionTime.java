import java.util.*;

public class ProcessExecutionTime {
    public static int minExecutionTime(int n, List<List<Integer>> dependencies) {
        // Создаем граф зависимостей
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            for (int dep : dependencies.get(i - 1)) {
                graph.get(dep).add(i);
                inDegree[i]++;
            }
        }

        // Топологическая сортировка
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>(queue);
            queue.clear();
            for (int curr : currLevel) {
                for (int next : graph.get(curr)) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> dependencies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = scanner.nextInt();
            List<Integer> deps = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                deps.add(scanner.nextInt());
            }
            dependencies.add(deps);
        }

        int minTime = minExecutionTime(n, dependencies);
        System.out.println(minTime);
    }
}
