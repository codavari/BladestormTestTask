import java.lang.IndexOutOfBoundsException

//я в книжку Лафоре про структуры данных на Java заглянул короче
class KotlinStack(capacity: Int) {

    private val buffer: Array<Any?> = arrayOfNulls(capacity)
    private val size = capacity //Размер массива, который изменять не надо
    private var top = -1 //Вершина стека

    fun push(o: Any?) {
        //не вычисляем размер массива каждый раз теперь
        if (top == size - 1) {
            //OutOfMemoryError про другое, также Exception отлавливать проще и по смыслу больше подходит
            throw IndexOutOfBoundsException()
        }
        //раньше не этот элемент, а следующий возвращали
        buffer[++top] = o //увеличили top, вставили элемент
    }

    //пусть юзер сам проверяет
    fun isEmpty(): Boolean {
        return (top == -1)
    }

    fun isFull(): Boolean {
        return (top == size - 1)
    }

    //зато теперь можем хранить null в стеке
    fun pop(): Any? {
        //раньше предыдущий элемент возвращали
        return buffer[top--]  //достали элемент, уменьшили top
    }

    fun equals(s: KotlinStack): Boolean {
        //сравнивать здесь лучше содержимое, а не ссылки
        return s.buffer.contentEquals(buffer)
    }

}