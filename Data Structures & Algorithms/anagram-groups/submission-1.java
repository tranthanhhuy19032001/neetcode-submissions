class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Set<String> ignoredStr = new HashSet<>();
        for(int i = 0; i < strs.length; i++) {

            if (ignoredStr.contains(strs[i])) {
                continue;
            }

            Map<Character, Integer> str1CharMap = countCharacter(strs[i]);

            List<String> strList = new ArrayList<>();
            strList.add(strs[i]);
            for(int j = i + 1; j < strs.length; j++) {
                Map<Character, Integer> str2CharMap = countCharacter(strs[j]);

                if (str1CharMap.equals(str2CharMap)) {
                    strList.add(strs[j]);
                    ignoredStr.add(strs[j]);
                }
            }
            result.add(strList);
        }
        return result;

    }

    public Map<Character, Integer> countCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

}
