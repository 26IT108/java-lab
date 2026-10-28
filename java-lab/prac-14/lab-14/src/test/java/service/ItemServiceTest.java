package service;

import model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    @Test
    void addingItemIncreasesCount() {
        ItemService service = new ItemService();

        service.addItem("Notebook");

        assertEquals(1, service.getCount());
    }

    @Test
    void invalidItemNameThrowsException() {
        ItemService service = new ItemService();

        assertThrows(IllegalArgumentException.class, () -> service.addItem(" "));
        assertThrows(IllegalArgumentException.class, () -> service.addItem(null));
    }

    @Test
    void savedDataCanBeLoadedUnchanged(@TempDir Path tempDir) throws Exception {
        Path saveFile = tempDir.resolve("items.dat");

        ItemService original = new ItemService();
        original.addItem("Notebook");
        original.addItem("Pen");
        original.saveToFile(saveFile.toString());

        ItemService restored = new ItemService();
        restored.loadFromFile(saveFile.toString());

        assertEquals(original.getCount(), restored.getCount());
        assertEquals(original.getItems().stream().map(Item::getName).toList(),
                     restored.getItems().stream().map(Item::getName).toList());
    }
}
