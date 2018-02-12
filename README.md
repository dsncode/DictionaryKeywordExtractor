# DictionaryKeywordExtractor

Given list of words (tokens) on text format, this api can help you to extract those words from an input text. in otherwords, this api can help to extract tokens from an input text

this api, provides a default english noun list. to use it, type:
```
DictionaryService.getInstance()
```

EXAMPLE: (given a english-nouns.txt input file):
Input: are there any doctors in the hospital this evening?
Output as **Future[List[Token]]**
```
[
  { 'token': 'doctor', 'classification': 'english-nouns'}, 
  { 'token': 'hospital', 'classification': 'english-nouns'}, 
  { 'token': 'evening', 'classification': 'english-nouns'}
]
```

USAGE 
```
  val text = "are there any doctors in the hospital this evening?"
  val dic = Dictionary.getInstance();
  val future_nouns: Future[List[Token]] = dic.findNouns(text)
```
