package advent.of.code.twentytwenty2.daySeven;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private final List<Directory> children;

    private ArrayList<Integer> listOfFiles = new ArrayList<>();
    private Directory parentDir;
    private String name;


    public void addFiles(Integer file) {
        listOfFiles.add(file);
    }

    public ArrayList<Integer> getListOfFiles() {
        return listOfFiles;
    }

    public Directory(String name) {
        this.children = new ArrayList<>();
        this.parentDir = null;
        this.name = name;
    }

    public Directory(String name, Directory parentDir) {
        // new node with a given parent
        this.children = new ArrayList<>();
        this.name = name;
        this.parentDir = parentDir;
        parentDir.addChild(this);
    }


    public List<Directory> getChildren() {
        return children;
    }

    public ArrayList<Integer> getAllSubFiles() {

        ArrayList<Integer> tempFiles = new ArrayList<>(this.getListOfFiles());
        if (this.getChildren().size() != 0) {
            for (Directory child : this.getChildren()) {
               tempFiles.addAll(child.getAllSubFiles());
            }
        }
        return tempFiles;
    }


    public Directory getParentDir() {
        return this.parentDir;
    }


    public void addChild(Directory child) {
        this.children.add(child);
    }

    public String getName() {
        return this.name;
    }


}