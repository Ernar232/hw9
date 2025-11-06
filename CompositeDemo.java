import java.util.ArrayList;
import java.util.List;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void display(String indent);
    public abstract int getSize();
}

class File extends FileSystemComponent {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Файл: " + name + " (" + size + "KB)");
    }

    @Override
    public int getSize() {
        return size;
    }
}
class Directory extends FileSystemComponent {
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void addComponent(FileSystemComponent component) {
        if (!components.contains(component)) {
            components.add(component);
        } else {
            System.out.println("Компонент '" + component.name + "' уже существует в '" + name + "'");
        }
    }

    public void removeComponent(FileSystemComponent component) {
        if (components.contains(component)) {
            components.remove(component);
        } else {
            System.out.println("Компонент '" + component.name + "' не найден в '" + name + "'");
        }
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Папка: " + name);
        for (FileSystemComponent component : components) {
            component.display(indent + "   ");
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}

public class CompositeDemo {
    public static void main(String[] args) {
        File file1 = new File("document.txt", 120);
        File file2 = new File("photo.jpg", 500);
        File file3 = new File("music.mp3", 7000);
        File file4 = new File("video.mp4", 15000);

        Directory folder1 = new Directory("Мои документы");
        Directory folder2 = new Directory("Медиа");
        Directory root = new Directory("Диск C");

        folder1.addComponent(file1);
        folder2.addComponent(file2);
        folder2.addComponent(file3);
        folder2.addComponent(file4);

        root.addComponent(folder1);
        root.addComponent(folder2);

        root.display("");

        System.out.println("\nОбщий размер '" + root.name + "': " + root.getSize() + "KB");
    }
}
