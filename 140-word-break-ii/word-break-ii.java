class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> result = new ArrayList<>();

        solve(s, wordDict, "", result);

        return result;
    }

    public void solve(String s, List<String> wordDict,
                      String sentence, List<String> result) {

        if (s.length() == 0) {
            result.add(sentence.trim());
            return;
        }

        for (String word : wordDict) {

            if (s.startsWith(word)) {

                String remaining = s.substring(word.length());

                solve(remaining, wordDict,
                      sentence + word + " ", result);
            }
        }
    }
}