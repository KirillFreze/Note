import org.junit.Test

import org.junit.Assert.*

class CreateNotesTest2 {

    @Test
    fun createComment() {
        val createNotes = CreateNotes
        createNotes.addNote(Notes(1, Note("Hello", "World")))
        val result = CreateNotes.createComment(NoteComment(1,1,"Hello")).message
        println(result)
        assertEquals("Hello", result)
    }
    @Test(expected = PostNotFoundExeption::class)
    fun shouldThrow() {
        val createNotes = CreateNotes
        createNotes.addNote(Notes(1, Note("Hello", "World")))
        val result = CreateNotes.createComment(NoteComment(2,1,"Hello")).message
        println(result)
        assertEquals("Hello", result)

    }
}