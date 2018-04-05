package Test;

import com.aninstein.bean.QuestionPO;
import com.aninstein.bean.SjtablePO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 */
public class TestObjectMapper {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper=new ObjectMapper();
        SjtablePO sjtablePO=new SjtablePO();

        List<QuestionPO> questionPOList=new ArrayList<>();
        questionPOList.add(new QuestionPO().setQuestionno("1")
                .setCorrectAnswer("1")
                .setQuestion("我长的帅么？")
                .setAnswers(Arrays.asList("帅,一般,不帅,呵呵".split(","))));
        questionPOList.add(new QuestionPO().setQuestionno("2")
                .setCorrectAnswer("2")
                .setQuestion("我是不是很聪明？")
                .setAnswers(Arrays.asList( "还行,聪明,一般聪 明,不聪明".split(","))));
        questionPOList.add(new QuestionPO().setQuestionno("3")
                .setCorrectAnswer("3")
                .setQuestion("我是不是很厉害？")
                .setAnswers(Arrays.asList( "一般,一般厉害,很厉害很厉害,厉害".split(","))));
        questionPOList.add(new QuestionPO().setQuestionno("4")
                .setCorrectAnswer("1")
                .setQuestion("c++的输入语句？")
                .setAnswers(Arrays.asList( "cin>>a;,printf();,input();,Scanner.in".split(","))));
        questionPOList.add(new QuestionPO().setQuestionno("5")
                .setCorrectAnswer("1")
                .setQuestion("飘香盐酥鸡多少钱？")
                .setAnswers(Arrays.asList(   "11块钱,23块,15块,100块".split(","))));


        sjtablePO.setSjname("第一份试卷")
                .setSjtag("吃的")
                .setSjcourseid("c语言")
                .setSjcoursechp("ch1")
                .setSjdescribe("乱七八糟")
                .setSjcontain(questionPOList);

        System.out.println(objectMapper.writeValueAsString(sjtablePO));

    }

}
