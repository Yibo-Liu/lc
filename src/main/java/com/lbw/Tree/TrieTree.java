package com.lbw.Tree;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TrieTree.java
 * @Description 前缀树的两种实现；
 * pass是经过此节点的次数；end是以此节点为结束的次数。
 * @createTime 2021年12月06日 15:24:00
 */
public class TrieTree {
    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            pass = 0;
            end = 0;
            // 0    a
            // 1    b
            // 2    c
            // ..   ..
            // 25   z
            // nexts[i] == null   i方向的路不存在
            // nexts[i] != null   i方向的路存在
            nexts = new Node1[26];//以小写英文字母为例，一个节点下面最多只有26个节点
        }
    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            root = new Node1();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }

            char[] str = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int path = 0;//path表示此节点下面节点路的方向
            for (int i = 0; i < str.length; i++) {
                path = str[i] - 'a';
                if (node.nexts[path] == null) {//如果没有路了，需要新建路
                    node.nexts[path] = new Node1();
                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }

        //查找word这个单词在之前加入过几次
        public int search(String word) {
            if (word == null) {
                return 0;
            }

            char[] chs = word.toCharArray();
            Node1 node = root;
            int path=0;
            for (int i = 0; i < chs.length; i++) {
                path = chs[i] - 'a';
                if (node.nexts[path] == null) {//如果没有路了，需要新建路
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.end;
        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            Node1 node = root;
            int path = 0;
            for (int i = 0; i < chs.length; i++) {
                path = chs[i] - 'a';
                if (node.nexts[path] == null) {//如果没有路了，需要新建路
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.pass;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                Node1 node = root;
                node.pass--;
                int path = 0;
                for (int i = 0; i < chs.length; i++) {
                    path = chs[i] - 'a';
                    if (--node.nexts[path].pass == 0) {
                        node.nexts[path] = null;//如果节点pass减完已经为0了，那就不用后面的节点了
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }





    }


}
