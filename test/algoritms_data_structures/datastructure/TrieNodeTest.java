package algoritms_data_structures.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by johntangarife on 10/9/17.
 */

public class TrieNodeTest {

    @Test
    public void addWordAndFindCountTest() {

        //Arrange
        String string1 = "hackerman";
        String string2 = "hack";
        String string3 = "hachis";
        TrieNode node = new TrieNode();

        //Act
        node.addWord(string1, 0);
        node.addWord(string2, 0);
        node.addWord(string3, 0);

        //Assert
        assertEquals(2, node.findCount(string2, 0));
        assertEquals(3, node.findCount("hac", 0));
        assertEquals(1, node.findCount("hach", 0));
        assertEquals(0, node.findCount("nop", 0));
    }
}
