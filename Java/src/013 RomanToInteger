class Solution {
    public int romanToInt(String s) {
        int[] array = new int['A' + 26];

        array['I'] = 1;
        array['V'] = 5;
        array['X'] = 10;
        array['L'] = 50;
        array['C'] = 100;
        array['D'] = 500;
        array['M'] = 1000;

        int result = 0;
        int previous = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = array[s.charAt(i)];
            result += previous > current ? -current : current;
            previous = current;
        }

        return result;
    }
}
