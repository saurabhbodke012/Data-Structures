class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double, List<String>> map = new HashMap<>();
        for(String s: strs){  
            double prime = doublePrime(s);
            if(!map.containsKey(prime)){
                map.put(prime,new ArrayList<>());
            }
            map.get(prime).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private static double doublePrime(String s){
        double result = 1;
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for(int i =0; i< s.length(); i++){
            char ch = s.charAt(i);
            result *= prime[ch - 'a'];
        }

        return result;
    }
}