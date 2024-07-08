package org.example;

import java.io.File;

public class Tree {
    public static void main(String[] args) {
        System.out.println("\n================ Первый вывод =================\n");

        // Вывод в консоль дерева с корнем - "." (текущая директория).
        print(new File("."), "", true);

        System.out.println("\n================ Следующий вывод =================\n");

        // Вывод в консоль дерева с корнем - "C:\\Users\\gulnu\\Desktop" (абс. путь).
        print(new File("C:\\Users\\gulnu\\Desktop"), "", true);
    }

    /**
     *
     * @param file Файл, начало (корень дерева)
     * @param intend левый отступ
     * @param isLast последний файл или поддиректория в ветке.
     */
    static void print(File file, String intend, boolean isLast) {
        System.out.print(intend);
        if (isLast) {
            System.out.print("└─");
            intend += "  ";
        } else {
            System.out.print("├─");
            intend += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null) {
            return;
        }

        int subDirOrFileTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory() || files[i].isFile()) {
                subDirOrFileTotal++;
            }
        }

        int subDirOrFileCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory() || files[i].isFile()) {
                print(files[i], intend, subDirOrFileTotal == ++subDirOrFileCounter);
            }
        }
    }
}