import java.io.File;
import java.util.*;

public class FileFinder {

        /**
         * TO-DO: Change this method to be recursive.
         \*
         * This method searches for a file with a specific name within a directory
         * and its subdirectories. The current implementation uses a Queue for an
         * iterative, breadth-first search.
         \*
         * @param rootDir The directory to start the search from.
         * @param fileName The name of the file to find.
         * @return The File object if found, otherwise null.
         */
/*        public File findFileByName(File rootDir, String fileName) {
            if (!rootDir.isDirectory()) {
                return null;
            }
            Queue<File> queue = new LinkedList<>();
            queue.offer(rootDir);
            while (!queue.isEmpty()) {
                File current = queue.poll();
                File[] files = current.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            queue.offer(file);
                        } else if (file.getName().equals(fileName)) {
                            return file;
                        }
                    }
                }
            }
            return null;
        }*/
        public File findFileByName(File rootDir, String fileName) {
            if (rootDir == null || !rootDir.isDirectory()) {
                return null;
            }

            File[] files = rootDir.listFiles();
            if (files == null) {
                return null;
            }

            return findFileByNameHelper(files, fileName, 0);
        }

    private File findFileByNameHelper(File[] files, String fileName, int index) {
        if (index >= files.length) {
            return null;
        }

        File current = files[index];

        if (current.isFile() && current.getName().equals(fileName)) {
            return current;
        }

        if (current.isDirectory()) {
            File found = findFileByName(current, fileName);
            if (found != null) {
                return found;
            }
        }
        return findFileByNameHelper(files, fileName, index + 1);
    }



    public static void main(String[] args) {
        FileFinder finder = new FileFinder();
        // 🎯 Customize these values for your test
        String rootPath = "C:\\Users\\CodeLine";           // Start from current directory (you can change this)
        String targetFileName = "ArrayFront9.java"; // File you want to find
        System.out.println("🔍 Searching for file: " + targetFileName);
        System.out.println("📂 Starting from directory: " + new File(rootPath).getAbsolutePath());

        File result = finder.findFileByName(new File(rootPath), targetFileName);

        if (result != null) {
            System.out.println("✅ File found: " + result.getAbsolutePath());
        } else {
            System.out.println("❌ File not found: " + targetFileName);
        }
    }
}
