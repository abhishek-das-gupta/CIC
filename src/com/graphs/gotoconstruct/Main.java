package com.graphs.gotoconstruct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {
    static Map<SqlStatement, List<SqlStatement>> adjList = new LinkedHashMap<>();
    static List<String> stmt = new ArrayList<>(Arrays.asList());
    static SqlStatement start = null;
    static Map<String, SqlStatement> stringToSql = new HashMap<>();
    static Map<SqlStatement, Integer> in = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/media/abhishek/Study/CIC/src/com/graphs/gotoconstruct/goto_source_3.text"));
        String s = br.readLine();
        while(s != null) {
            stmt.add(s);
            s = br.readLine();
        }
//        System.out.println(stmt.toString());
        parseGotoConstruct();
//        for(SqlStatement k : adjList.keySet()) {
//            System.out.print(k.val + " -> ");
//            for(SqlStatement adj : adjList.get(k)){
//                System.out.print(adj.val + " ");
//            }
//            System.out.println();
//        }
        dfs(start.val);
    }

    private static void parseGotoConstruct() {
        String prev = null;
        int idx = 0;
        while(idx < stmt.size()){
            String cur = stmt.get(idx);
            if(cur.contains("if")){
                if(cur.contains("goto")) {
                    String label = getLabel(cur);
                    String notIf = negateIfCondition(cur);
                    addEdge(prev, notIf);
                    String tmpPrev = notIf;
                    int j = idx+1;
                    while(j < stmt.size() && !stmt.get(j).equals(".label " + label + ":")){
                        String tmpCur = stmt.get(j);
                        if(tmpCur.contains(".label")) {
                            j++;
                            continue;
                        }
//                        else if(tmpCur.contains("if")) {
//                            Set<String> se
//                            catchIfBlock(tempPrev, idx, );
//                        }
                        addEdge(tmpPrev, tmpCur);
                        tmpPrev = tmpCur;
                        j++;
                    }
                    j++;
                    if(j >= stmt.size()) break;
                    if(stmt.get(j).contains("if")) {
                        stringToSql.put(tmpPrev,  new SqlStatement(stringToSql.get(tmpPrev).val + "\n}"));
                        prev = tmpPrev;
                        idx = j;
                    }
                    else {
                        stringToSql.put(tmpPrev,  new SqlStatement(stringToSql.get(tmpPrev).val + "\n}"));
                        addEdge(tmpPrev, stmt.get(j));
//                    addEdge(prev, stmt.get(j));
                        prev = stmt.get(j);
                        idx = j + 1;
                    }
                }
            }
            else if(cur.contains("goto")) {
                String label = getLabel(cur);
                int j = idx;
                while (j < stmt.size() && !stmt.get(j).equals(".label " + label + ":")) {
                    j++;
                }
                j++;
                if (j >= stmt.size()) break;
                if (stmt.get(j).contains("if")) {
                    idx = j;
                } else {
                    addEdge(prev, stmt.get(j));
                    prev = stmt.get(j);
                    idx = j+1;
                }
            }
            else if(cur.contains(".label")){
                idx++;
            }
            else{
                if(prev != null){
                    addEdge(prev, cur);
                }
                else{
                    start = new SqlStatement(cur);
                }
                prev = cur;
                idx++;
            }
        }
    }
    private static String createTrueIf(){
        return "if(true){";
    }
    private static void addEdge(String p, String c){
        stringToSql.putIfAbsent(p, new SqlStatement(p));
        stringToSql.putIfAbsent(c, new SqlStatement(c));
        SqlStatement pSql = stringToSql.get(p);
        SqlStatement cSql = stringToSql.get(c);
        adjList.putIfAbsent(pSql, new ArrayList<>());
        adjList.get(pSql).add(cSql);
    }
    private static String negateIfCondition(String s){
        int l = s.indexOf("(");
        int r = s.indexOf(")");
        s = s.substring(0, r+1);
        String condition = s.substring(l+1, r);
        String operator = condition.split(" ")[1];
        String notOperator = getNegationOperator(operator);
        return s.replace(operator, notOperator) + "{";

    }
    private static String getNegationOperator(String opt){
        switch(opt) {
            case "=":
                return "<>";
            case "<>":
                return "=";
            default:
                throw new IllegalArgumentException("Negation of the operator is not supported yet !!!");
        }
    }
    private static String getLabel(String s){
        int l = s.indexOf("goto");
        while(s.charAt(l) != ' ') l++;
        return s.substring(l+1, s.length());
    }
    private static void dfs(String cur){
        System.out.println(stringToSql.get(cur).val.trim());
        //if(cur.contains("\n}")) cur = cur.replace("\n}", "");
        for(SqlStatement adj : adjList.getOrDefault(stringToSql.get(cur), new ArrayList<>())){
            dfs(adj.val);
        }

    }
    static class SqlStatement{
        String val;
        public SqlStatement(String val){
            this.val  = val;
        }
        public boolean equals(Object o) {
            if(o == null) return false;
            if(o.getClass() != this.getClass()) return false;
            if(this == o) return true;
            SqlStatement that = (SqlStatement) o;
            if(this.val.equals(that.val)) return true;
            return false;
        }
        public int hashCode(String val){
            return Objects.hash(val);
        }
    }
}