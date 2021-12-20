package optic_fusion1.anna.shellparser.states;

import java.util.List;
import optic_fusion1.anna.shellparser.ParseException;

public class QuoteState extends State {

  private char quote;

  public QuoteState(char quote) {
    this.quote = quote;
  }

  @Override
  public List<String> parse(String parsing, String accumulator, List<String> parsed, State referrer) throws ParseException {
    if (parsing.length() == 0) {
      throw new ParseException("Mismatched quote character: " + this.quote);
    }
    char c = (char) parsing.getBytes()[0];
    if (c == '\\') {
      return new EscapeState().parse(parsing.substring(1), accumulator, parsed, this);
    }
    if (c == this.quote) {
      return new StartState().parse(parsing.substring(1), accumulator, parsed, this);
    }
    return new QuoteState(this.quote).parse(parsing.substring(1), accumulator + c, parsed, this);
  }
}
