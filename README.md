 Byte Size & Time Duration Parsing Support

You can now use data units like `10KB`, `1.5MB`, `2s`, `150ms` directly in directives.

Sample Directive:
java
aggregate-stats :data :time total_size_mb 


 Prompts.txt 
txt
Prompt 1: Write a Java class that parses strings like "10MB" or "1.5GB" and converts them to bytes.
Prompt 2: Create a Wrangler directive that aggregates a column of sizes and times using new unit parsers.
Prompt 3: How do I add new token types to CDAP Wrangler’s grammar using ANTLR?

