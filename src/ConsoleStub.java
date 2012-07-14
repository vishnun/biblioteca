import java.util.ArrayList;
import java.util.List;

public class ConsoleStub implements Console {
    private final List<String> lines = new ArrayList<String>();
    private List<String> InputList=new ArrayList<String>();

    public String getLine(int lineNumberOneBased) {
        return lines.get(lineNumberOneBased - 1);        //console to the test
    }

    @Override
    public void println(String s) {   //object to console
        lines.add(s);
    }

    @Override
    public void println(int i) {
        lines.add(String.valueOf(i));
    }

    @Override
    public String GetUserInput(int inputNo) {
        if(inputNo<0||inputNo>InputList.size()) lines.add("Not a valid Input");
        return InputList.get(inputNo-1);
    }

    public void InitializeInputSequence(ArrayList<String> inputListOrder) {
        for (String input : inputListOrder) {
            InputList.add(input);
        }
    }
}
