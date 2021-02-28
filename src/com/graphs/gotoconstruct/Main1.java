package com.graphs.gotoconstruct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main1 {
    private static Map<SqlStatement, List<SqlStatement>> adjList = new LinkedHashMap<>();
    private static List<String> stmt = new ArrayList<>();
    private static SqlStatement start = null;
    private static Map<String, SqlStatement> stringToSql = new HashMap<>();
    private static int counter = 0;
    private static Map<String, String> ifToNotif = new HashMap<>();
    private static Map<String, String> gotoToFalseif = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/media/abhishek/Study/CIC/src/com/graphs/gotoconstruct/goto_source_2.text"));
        String s = br.readLine();
        while(s != null) {
            if(s.trim().isEmpty()){
                s = br.readLine();
                continue;
            }
            stmt.add(s);
            s = br.readLine();
        }
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
                    int j = catchIfBlock(prev, idx, new HashSet<>());
                    if(j >= stmt.size()) break;
                    prev = j-1 < 0 ? null : stmt.get(j-1);
                    idx = j;
                }
            }
            else if(cur.contains("goto")) {
                int j = catchGotoBlock(prev, idx, new HashSet<>());
                if(j >= stmt.size()) break;
                prev = j-1 < 0 ? null : stmt.get(j-1);
                if(prev != null && prev.contains("if") && prev.contains("goto"))
                    prev = ifToNotif.get(prev);
                else if(prev != null && prev.contains("goto"))
                    prev = gotoToFalseif.get(prev);
                idx = j;
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
    private static int catchIfBlock(String prev, int i, Set<String> set) {
        String cur = stmt.get(i);
        String label = getLabel(cur);
        boolean sameLabel = false;
        if(set.contains(".label " + label + ":")){
            sameLabel = true;
        }
        set.add(".label " + label + ":");
        String notIf = negateIfCondition(cur);
        ifToNotif.put(cur, notIf);
        addEdge(prev, notIf);
        String tmpPrev = notIf;
        int j = i + 1;
        boolean scope = false;
        while (j < stmt.size() && !stmt.get(j).equals(".label " + label + ":")) {
            String tmpCur = stmt.get(j);
            if (tmpCur.contains(".label")) {
                if (set.contains(tmpCur)) {
                    scope = true;
                    set.remove(".label " + label + ":");
                    break;
                }
                j++;
                continue;
            } else if (tmpCur.contains("if")) {
                j = catchIfBlock(tmpPrev, j, set);
                tmpPrev = j-1 < 0 ? null : stmt.get(j-1);
                if(tmpPrev != null && tmpPrev.contains("if")) {
                    tmpPrev = ifToNotif.get(tmpPrev);
                }
                continue;
            }
            addEdge(tmpPrev, tmpCur);
            tmpPrev = tmpCur;
            j++;
        }
        if(sameLabel){
            stringToSql.put(tmpPrev, new SqlStatement(stringToSql.get(tmpPrev).val + "\n}"));
            return j;
        }
        if(scope) {
            stringToSql.put(tmpPrev, new SqlStatement(stringToSql.get(tmpPrev).val + "\n}"));
            return j;
        }
        j++;
        if(j >= stmt.size()) {
            return j;
        }
        else if (stmt.get(j).contains("if")) {
            stringToSql.put(tmpPrev, new SqlStatement(stringToSql.get(tmpPrev).val + "\n}"));
            return j;
        } else {
            stringToSql.put(tmpPrev, new SqlStatement(stringToSql.get(tmpPrev).val + "\n}"));
            addEdge(tmpPrev, stmt.get(j));
            return j+1;
        }
    }

    private static int catchGotoBlock(String prev, int i, Set<String> set){
        String cur = stmt.get(i);
        String label = getLabel(cur);
        boolean sameLabel = false;
        if(set.contains(".label " + label + ":")){
            sameLabel = true;
        }
        set.add(".label " + label + ":");
        String tmpPrev = ifFalse();
        gotoToFalseif.put(cur, tmpPrev);
        addEdge(prev, tmpPrev);
        int j = i+1;
        boolean scope = false;
        boolean enter = false;
        while (j < stmt.size() && !stmt.get(j).equals(".label " + label + ":")) {
            enter = true;
            String tmpCur = stmt.get(j);
            if(tmpCur.contains(".label")){
                if(set.contains(tmpCur)){
                    scope = true;
                    set.remove(".label " + label + ":");
                    break;
                }
                j++;
                continue;
            }
            else if(tmpCur.contains("goto")){
                j = catchGotoBlock(tmpPrev, j, set);
                tmpPrev = j-1 < 0 ? null : stmt.get(j-1);
                if(tmpPrev != null && tmpPrev.contains("goto"))
                    tmpPrev = gotoToFalseif.get(tmpPrev);
                continue;
            }
            addEdge(tmpPrev, tmpCur);
            tmpPrev = tmpCur;
            j++;
        }
        if(sameLabel) {
            stringToSql.put(tmpPrev, new SqlStatement(stringToSql.get(tmpPrev).val + "\n}"));
            return j;
        }
        if(scope || !enter){
            stringToSql.put(tmpPrev, new SqlStatement(stringToSql.get(tmpPrev).val + "\n}"));
            return j;
        }
        j++;
        if (j >= stmt.size()){
            return j;
        }
        else if (stmt.get(j).contains("if")) {
            stringToSql.put(tmpPrev, new SqlStatement(stringToSql.get(tmpPrev).val + "\n}"));
            return j;
        } else {
            stringToSql.put(tmpPrev, new SqlStatement(stringToSql.get(tmpPrev).val + "\n}"));
            addEdge(tmpPrev, stmt.get(j));
            return j+1;
        }
    }

    private static String ifFalse(){
        String ifFalse = "if(false){";
        if(!stringToSql.containsKey(ifFalse)){
            counter++;
            return ifFalse;
        }
        String spaces = " ";
        for(int i=0; i<=counter; ++i) spaces += " ";
        return ifFalse + spaces;
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
            case "<":
                return ">=";
            case "<=":
                return ">";
            case ">":
                return "<=";
            case ">=":
                return "<";
            default:
                throw new IllegalArgumentException("Negation of the operator is not supported yet !!!");
        }
    }
    private static String getLabel(String s){
        int l = s.indexOf("goto");
        while(s.charAt(l) != ' ') l++;
        return s.substring(l+1);
    }
    private static void dfs(String cur){
        System.out.println(stringToSql.get(cur).val.trim());
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
