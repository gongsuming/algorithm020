字典树：脑海里有课件上的描述图，插入、查询操作一步一步来就行
>1 insert: 拿到当前的字母数组next，依次遍历传入的单词的字符;
           如果当前字符不在next中，生成一个新的节点，并将当前的节点指向新生成的节点;
           如果当前字符在next中，将该字符所在的节点指向当前的节点;
           在单词被遍历结束时，给当前所在的节点设置isEnd的标记，表示以当前字符结束可以形成一个字母.
>2 search: 遍历字母的所有字符，如果当前字符所在的节点不存在，返回false，说明单词还没搜完，树已经断了
>3 startsWith: 同上。但是search需要判断当前节点是否是isEnd，如果是的话，证明是搜索到了，startsWith则不需要满足此条件

class Trie {

    Trie[] next = new Trie[26];
    boolean isEnd = false;

    /** Initialize your data structure here. */
    public Trie() {
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new Trie();
            }
            curr = curr.next[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                return false; 
            }
            curr = curr.next[c - 'a'];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (char c : prefix.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                return false;
            } 
            curr = curr.next[c - 'a'];
        }
        return true;
    }
}