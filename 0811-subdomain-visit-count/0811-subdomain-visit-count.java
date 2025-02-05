class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countDomainMap = new HashMap<>();

        for (String cpdomain : cpdomains) {
            List<Pair<String, Integer>> domainCountPairs = getDomainCountPairs(cpdomain);

            for (Pair<String, Integer> domainCountPair : domainCountPairs) {
                String domain = domainCountPair.getKey();
                int count = domainCountPair.getValue();

                countDomainMap.put(domain, countDomainMap.getOrDefault(domain, 0) + count);
            }
        }

        List<String> visitList = new ArrayList<>();
        for (Map.Entry<String, Integer> countDomain : countDomainMap.entrySet()) {
            String visitString = countDomain.getValue() + " " + countDomain.getKey();
            visitList.add(visitString);
        }

        return visitList;
    }

    private List<Pair<String, Integer>> getDomainCountPairs(String cpdomain) {
        String[] domainSplit = cpdomain.split(" ");
        String[] domains = domainSplit[1].split("\\.");
        int count = Integer.parseInt(domainSplit[0]);

        List<Pair<String, Integer>> domainCountPairs = new ArrayList<>();
        String db = "";
        for (int i = 0; i < domains.length; i++) {
            String domain = domains[domains.length-1-i];
            if (db.length() > 0) db = "." + db;
            db = domain + db;
            domainCountPairs.add(new Pair<>(db, count));
        }

        return domainCountPairs;
    }
}