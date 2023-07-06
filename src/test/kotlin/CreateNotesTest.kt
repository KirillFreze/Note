import org.junit.Test

import org.junit.Assert.*

class CreateNotesTest {

    @Test
    fun addNote() {
        val createNotes = CreateNotes
        val result = createNotes.addNote(Notes(1, Note("Hello", "World"))).id

        assertEquals(1,result)
    }
}