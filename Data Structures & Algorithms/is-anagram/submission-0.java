class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = countCharacter(s);
        Map<Character, Integer> mapT = countCharacter(t);

        if (mapS.equals(mapT)) return true;
        return false;
    }

    public Map<Character, Integer> countCharacter(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}