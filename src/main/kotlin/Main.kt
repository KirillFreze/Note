class PostNotFoundExeption(message: String) : RuntimeException(message)
class Note(
    val title: String,
    val text: String
)

data class NoteComment(
    val idNote: Int,
    var idComment: Int,
    val message: String
)

data class Notes(
    val id: Int,
    val note: Note


)

object CreateNotes {
    public var unicId = 1
    public var unicIdComment = 1
    val notes = mutableListOf<Notes>()
    val comments = mutableListOf<NoteComment>()
    val deleteComments = mutableListOf<NoteComment>()
    fun addNote(note: Notes): Notes {
        notes += note.copy(id = unicId++)
        return notes.last()


    }

    fun createComment(comment: NoteComment): NoteComment {
        for (i in 0..notes.size - 1) {
            if (comment.idNote.equals(notes[i].id)) {
                comments += comment.copy(idComment = unicIdComment++)
                return comments.last()
            }


        }
        throw PostNotFoundExeption("Not note")
        return comments.last()
    }

    fun delete(noteId: Int): Boolean {
        for (i in 0..notes.size - 1) {
            if (noteId.equals(notes[i].id)) {
                notes.removeAt(i)
                return true
            }
        }
        throw PostNotFoundExeption("Not note")
        return false
    }

    fun deleteComment(noteId: Int, commentId: Int): Boolean {
        for (i in 0..comments.size - 1) {
            if (noteId.equals(comments[i].idNote) && commentId.equals((comments[i].idComment))) {
                deleteComments += comments[i]
                comments.removeAt(i)
                return true
            }
        }
        throw PostNotFoundExeption("Not comment")
        return false
    }

    fun updateNote(note: Notes): Boolean {
        for (i in 0..notes.size - 1) {
            if (note.id.equals(notes[i].id)) {
                notes[i] = note
                return true
            }
        }
        throw PostNotFoundExeption("Not note")
        return false
    }

    fun updateComments(comment: NoteComment): Boolean {
        for (i in 0..comments.size - 1) {
            if (comment.idNote.equals(comments[i].idNote) && comment.idComment.equals(comments[i].idComment)) {
                comments[i] = comment
                return true
            }
        }
        throw PostNotFoundExeption("Not comment")
        return false
    }

    fun get(): MutableList<Notes> {
        return notes
    }

    fun getById(noteId: Int): Notes {

        return notes[noteId - 1]

    }

    fun getComments(noteId: Int): MutableList<NoteComment> {
        var listComment = mutableListOf<NoteComment>()
        for (i in 0..comments.size - 1) {
            if (noteId.equals(comments[i].idNote)) {
                listComment += comments[i]
            }

        }
        return listComment
    }

    fun restoreComment(noteId: Int, commentId: Int): Boolean {
        for (i in 0..deleteComments.size - 1) {
            if (noteId.equals(deleteComments[i].idNote) || commentId.equals((deleteComments[i].idComment))) {
                comments += comments[i]
                deleteComments.removeAt(i)
                return true
            }
        }
        throw PostNotFoundExeption("Not comment")
        return false
    }
}
fun main(args: Array<String>) {
    var userNotes = CreateNotes
    userNotes.addNote(Notes(1, Note("Hello", "World")))
    userNotes.addNote(Notes(1, Note("Dark", "Side")))
    userNotes.addNote(Notes(1, Note("Tonny", "Stark")))
    userNotes.get()
    userNotes.createComment(NoteComment(1, 1, "Hello"))
    userNotes.createComment(NoteComment(1, 1, "Hello"))
    userNotes.createComment(NoteComment(1, 1, "Hello"))
    userNotes.createComment(NoteComment(2, 1, "Hello"))
    userNotes.createComment(NoteComment(2, 1, "Hello"))
    userNotes.getComments(1)
    userNotes.deleteComment(1, 2)
    userNotes.getComments(1)
    userNotes.getById(2)
}