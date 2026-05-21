class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, Map<Character, Integer>> strMap = new HashMap<>();
        for(String str : strs) {
            strMap.put(str, countCharacter(str));
        }

        Set<String> ignoredStr = new HashSet<>();
        for(int i = 0; i < strs.length; i++) {
            
            if (ignoredStr.contains(strs[i])) {
                continue;
            }

            List<String> strList = new ArrayList<>();
            strList.add(strs[i]);
            for(int j = i + 1; j < strs.length; j++) {
                if (strMap.get(strs[i]).equals(strMap.get(strs[j]))) {
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
