class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> recipeSet = new HashSet<>(Arrays.asList(recipes));
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient : ingredients.get(i)) {
                graph.computeIfAbsent(ingredient, _ -> new ArrayList<>()).add(recipes[i]);
            }
            indegree.put(recipes[i], ingredients.get(i).size());
        }

        Queue<String> bfs = new LinkedList<>();
        for (int i = 0; i < supplies.length; i++) {
            bfs.offer(supplies[i]);
        }

        List<String> availableRecipe = new ArrayList<>();
        while (!bfs.isEmpty()) {
            String ingredient = bfs.poll();
            if (recipeSet.contains(ingredient)) {
                availableRecipe.add(ingredient);
            }

            for (String unlockedRecipe : graph.getOrDefault(ingredient, new ArrayList<>())) {
                int degree = indegree.get(unlockedRecipe);
                indegree.put(unlockedRecipe, degree - 1);
                if (degree == 1) {
                    bfs.offer(unlockedRecipe);
                }
            }
        }

        return availableRecipe;
    }
}