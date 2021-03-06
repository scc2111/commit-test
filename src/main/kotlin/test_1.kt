
import java.text.SimpleDateFormat


fun readLineTrim() = readLine()!!.trim()

fun main() {
    println("== 게시판 관리 프로그램 시작 ==")

    var articlesLastId = 0   // 가장 마지막에 입력된 게시물 번호

    val articles = mutableListOf<Article>()   // 리스트 , 변화 가능


    loop@ while (true) {

        print("명령어) ")
        val command = readLineTrim()

        when (command) {
            "system exit" -> {
                println("프로그램을 종료합니다")
                break@loop
            }
            "article write" -> {
                val id = articlesLastId + 1
                val regDate = Util.getNowDateStr()
                val updateDate = Util.getNowDateStr()

                print("제목: ")
                val title = readLineTrim()
                print("내용: ")
                val body = readLineTrim()
                val article = Article(id, regDate, updateDate, title, body)

                println("${id}번 게시물이 작성되었습니다.")

                articles.add(article)    // articles[0] = article

                articlesLastId = id
            }
            "article list" -> {
                println("번호 / 작성날짜 / 제목")

                for (article in articles) {

                    println("${article.id} / ${article.regDate} / ${article.title}")

                }
            }
            else -> {
                println("'$command' 은(는) 존재하지 않는 명령어 입니다.")
            }
        }
    }
    println("== 게시판 관리 프로그램 끝 ==")
}

data class Article(
    val id: Int,
    val regDate: String,
    val updateDate: String,
    val title: String,
    val body: String,
)

object Util {
    fun getNowDateStr(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        return dateFormat.format(System.currentTimeMillis())

    }
}