class Solution {

        public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append(",");
        }
        sb.append("#");
        for(String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
       int charIndex = 0;
        while(str.charAt(charIndex) != '#') {
            StringBuilder sb = new StringBuilder();
            while(str.charAt(charIndex) != ',') {
                sb.append(str.charAt(charIndex));
                charIndex++;
            }
            sizes.add(Integer.parseInt(sb.toString()));
            charIndex++;
        }
        charIndex++;
        for(Integer size : sizes) {
            result.add(str.substring(charIndex,charIndex+size));
            charIndex+=size;
        }
return result;
    }
}