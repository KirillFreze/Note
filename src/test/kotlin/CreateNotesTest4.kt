import org.junit.Test

import org.junit.Assert.*

class CreateNotesTest4 {

    @Test
    fun deleteComment() {
        val createNotes = CreateNotes
        createNotes.addNote(Notes(1, Note("Hello", "World")))
        createNotes.addNote(Notes(1, Note("Hello", "World")))
        createNotes.createComment(NoteComment(1,1,"Hello"))
        createNotes.createComment(NoteComment(1,1,"Hello"))
        createNotes.createComment(NoteComment(1,1,"Hello"))
        val result = createNotes.deleteComment(1,2)
        assertTrue(result)
    }
    @Test(expected = PostNotFoundExeption::class)
    fun shouldThrow() {
        val createNotes = CreateNotes
        createNotes.addNote(Notes(1, Note("Hello", "World")))
        createNotes.addNote(Notes(1, Note("Hello", "World")))
        createNotes.createComment(NoteComment(1,1,"Hello"))
        createNotes.createComment(NoteComment(1,1,"Hello"))
        createNotes.createComment(NoteComment(1,1,"Hello"))
        val result = createNotes.deleteComment(1,5)
        assertFalse(result)

    }
}