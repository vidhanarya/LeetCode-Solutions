class MovieRentingSystem {
    Map<String, Integer> priceMap;
    Map<Integer, SortedSet<Integer>> availableMovies;
    SortedSet<String> rentedMovies;

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        availableMovies = new HashMap<>();

        rentedMovies = new TreeSet<>(Comparator.comparingInt(e -> priceMap.getOrDefault(e, Integer.MAX_VALUE)));

        for (int[] e : entries) {
            int shopId = e[0], movieId = e[1], price = e[2];
            String entry = shopId + ", " + movieId;
            priceMap.put(entry, price);
            if (!availableMovies.containsKey(movieId)) {
                availableMovies.put(movieId, new TreeSet<>((a, b) -> {
                    int priceA = priceMap.getOrDefault(a + ", " + movieId, Integer.MAX_VALUE);
                    int priceB = priceMap.getOrDefault(b + ", " + movieId, Integer.MAX_VALUE);
                    if (priceA != priceB) return priceA - priceB;
                    return a - b;
                }));
            }
            availableMovies.get(movieId).add(shopId);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> shops = new ArrayList<>();
        if (!availableMovies.containsKey(movie)) return shops;

        for (int shopId : availableMovies.get(movie)) {
            shops.add(shopId);
            if (shops.size() == 5) break;
        }

        return shops;
    }

    public void rent(int shop, int movie) {
        availableMovies.get(movie).remove(shop);
        rentedMovies.add(shop + ", " + movie);
    }

    public void drop(int shop, int movie) {
        rentedMovies.remove(shop + ", " + movie);
        availableMovies.get(movie).add(shop);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        for (String e : rentedMovies) {
            String[] split = e.split(", ");
            int shopId = Integer.parseInt(split[0]);
            int movieId = Integer.parseInt(split[1]);

            result.add(List.of(shopId, movieId));
            if (result.size() == 5) break;
        }

        return result;
    }
}