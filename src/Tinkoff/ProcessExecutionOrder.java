package Tinkoff;

import java.util.*;

public class ProcessExecutionOrder {
    public static List<List<Integer>> findExecutionOrder(int n, List<List<Integer>> dependencies) {
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

        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>(queue);
            queue.clear();
            Collections.sort(currLevel); // Сортируем процессы в текущем множестве
            result.add(currLevel);
            for (int curr : currLevel) {
                for (int next : graph.get(curr)) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return result;
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

        List<List<Integer>> executionOrder = findExecutionOrder(n, dependencies);
        System.out.println(executionOrder.size());
        for (List<Integer> level : executionOrder) {
            System.out.print(level.size() + " ");
            for (int process : level) {
                System.out.print(process + " ");
            }
            System.out.println();
        }
    }
}
