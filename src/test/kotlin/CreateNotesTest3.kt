import org.junit.Test

import org.junit.Assert.*

class CreateNotesTest3 {

    @Test
    fun delete() {
        val createNotes = CreateNotes
        createNotes.addNote(Notes(1, Note("Hello", "World")))
        createNotes.addNote(Notes(1, Note("Hello", "World")))
        val result = createNotes.delete(1)
        assertTrue(result)
    }
    @Test(expected = PostNotFoundExeption::class)
    fun shouldThrow() {
        val createNotes = CreateNotes
        createNotes.addNote(Notes(1, Note("Hello", "World")))
        createNotes.addNote(Notes(1, Note("Hello", "World")))
        val result = createNotes.delete(3)
        assertFalse(result)

    }
}