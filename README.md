# ADK--DD2350
Algoritmer, datastrukturer och komplexitet( adk23)

Kursens PM: https://www.kth.se/kurs-pm/DD2350/20232/50129

Kursens innehåller 5 labbar : 

**Lab1**:

En konkordans är en datastruktur där man kan slå upp ord och då få se alla förekomster av ordet tillsammans med orden närmast före och närmast efter i texten. Detta är ett stort hjälpmedel för lingvister som vill undersöka hur olika ord används i språket.

I denna uppgift ska ni skriva ett program som givet en text skapar en konkordansdatastruktur på filsystemet samt ett program som frågar användaren efter ord, slår upp ordet och presenterar alla förekomster av ordet i sitt sammanhang. Det är viktigt att varje sökning går mycket snabbt så det gäller att det första programmet lagrar konkordansdatastrukturen på ett sådant sätt att det går snabbt att göra en sökning.

Exempel på körning av sökprogrammet:

$ java Konkordans algoritmens
Det finns 12 förekomster av ordet.
let.  Historia  Cooley  Tukey-algoritmens historia börjar kring år 1805
 att jämföra målvariabeln med algoritmens estimering av målvariabeln. V
alsdivision skulle detta vara algoritmens totala komplexitet. Dock kvar
maximala använda minnet under algoritmens gång är det intressanta. Form
använda binär exponentiering. Algoritmens korrekthet förklaras som följ
 rötter kommer att klara båda algoritmens steg. Stage Junior 2006 Stage
r till nod 4 (se nästa bild). Algoritmens steg upprepas, och det är nu
att lära en robothund att gå. Algoritmens förmåga att lösa problemet be
ma problem. Ett annat ord för algoritmens resursberoende är komplexitet
rterad listan är från början. Algoritmens komplexitet blir O (N²).  Ins
2006) har visat att Masreliez-algoritmens prestanda är relativt bättre
 det behövs även en algoritm. Algoritmens uppgifter är att dela in talp 
Parprogrammering
För att få labbleveranspoäng på denna labb måste ni (förutom att redovisa den senast ovanstående datum) genomföra den i tvåpersonsgrupper som arbetar enligt den agila programutvecklingstekniken parprogrammering. Läs här om parprogrammering.

Krav
Följande krav ställs på er lösning:

Programmet ska vara skrivet i ett riktigt programspråk och inte något operativsystemnära skriptspråk eller liknande.

Konkordansen ska inte skilja på stora och små bokstäver. Användaren ska alltså kunna skriva in alla sökfrågor med små bokstäver, stora bokstäver eller godtycklig blandning.

Det givna programmet tokenizer.c på kurskatalogen (se nedan) definierar hur texten ska delas upp i enskilda ord.
Konstruktionsprogrammet behöver inte vara jättesnabbt eftersom det bara ska köras en gång, men det måste vara någorlunda effektivt så att det kan skapa konkordansdatastrukturen på rimlig tid. Det får inte ta mer än tre minuter att skapa konkordansdatastrukturen på en Ubuntudator (utöver tiden att köra tokenizer och sort).

Sökprogrammets utmatning ska inledas med en rad som anger antalet förekomster. Därefter ska varje förekomst av ordet presenteras på varje rad med till exempel 30 tecken före och 30 tecken efter. Ersätt radbyten med mellanslag. Om det finns fler än 25 förekomster ska programmet fråga användaren om vederbörande vill ha förekomsterna utskrivna på skärmen.

Man ska kunna söka efter ett ord, till exempel bil, genom att i terminalfönstret ge kommandot ./konkordans bil (om ni använt C, C++ eller liknande), python3 konkordans.py bil (om ni använt Python) eller java Konkordans bil (om ni använt Java). 

Svaret (som alltså innehåller antalet förekomster men högst 25 rader med förekomster) måste komma inom en sekund på skolans Ubuntudatorer. Vid redovisningen ska programmet exekveras på en av skolans Ubuntudatorer (för fjärrinloggning, se nedan).

Sökprogrammet ska inte läsa igenom hela texten och får inte använda speciellt mycket internminne. Internminnesbehovet ska inte växa med antalet distinkta ord i den ursprungliga texten (med andra ord ha konstant internminneskomplexitet). Ni ska därför använda latmanshashning (se föreläsning 3) som datastruktur. Vid redovisningen ska ni kunna motivera att internminneskomplexiteten är konstant för sökprogrammet.

Prova att bara använda linjärsökning i indexfilen och jämför med att först använda binärsökning tills sökintervallet är litet och därefter linjärsökning (se pseudokoden i föreläsning 3) och se om det gör skillnad i körtid för något sökord. För vilken typ av sökord borde det teoretiskt sett gå snabbare med binärsökning? Ni kan till exempel mäta körtiden med Unixkommandot time (skriv time först i kommandot som startar ert sökprogram) och kolla på tiden för user. 

**Lab2**:

I katalogen /afs/kth.se/misc/info/kurser/DD2350/adk23/labb2 finns ett Javaprogram som löser nedanstående problem. Din uppgift är att snabba upp programmet så att det går ungefär 10000 gånger snabbare. Korrekthet och effektivitet testas dels genom inbyggda test och dels genom att programmet skickas till Kattis Links to an external site.. För att klara labben ska du bli godkänd av Kattis samt redovisa labben för en handledare. Börja med att logga in i Kattis och anmäla dig till adk23 i menyalternativet Kurser i översta menyn.

Problem
Editeringsavståndet mellan två ord är det minimala antalet bokstavsoperationer som krävs för att transformera det ena ordet till det andra. Det finns tre tillåtna bokstavsoperationer:

ta bort en av bokstäverna i ordet

lägg till en bokstav någonstans i ordet

byt ut en bokstav i ordet mot en annan bokstav

Till exempel kan ordet alroitm transformeras till algoritm genom att bokstaven r byts ut mot g (regel 3) och bokstaven r skjuts in efter bokstaven o (regel 2). Kedjan

alroitm -> algoitm -> algoritm

visar att editeringsavståndet mellan alroitm och algoritm är högst 2. Eftersom det inte går att transformera alroitm till algoritm i en enda bokstavsoperation så är editeringsavståndet mellan orden precis 2.

Ett vanligt sätt att ta fram rättstavningsförslag till ett felstavat ord är att helt enkelt returnera dom ord i ordlistan som har minst editeringsavstånd till det felstavade ordet. Programmet ska givet en ordlista och ett antal felstavade ord beräkna rättstavningsförslag på detta sätt.

Specifikation
Indata består av två delar. Den första delen är ordlistan, som består av ett antal ord i utf-8-bokstavsordning, ett ord per rad. Denna del avslutas av en rad som bara innehåller ett '#'-tecken. Den andra delen är ett antal felstavade ord som ska rättstavas, ett ord per rad. Dom felstavade orden ingår inte i ordlistan. Varje ord i indata består bara av små bokstäver i svenska alfabetet (a-z, å, ä, ö), inga mellanslag, skiljetecken eller siffror.

Programmet ska för varje felstavat ord skriva ut en rad bestående av det felstavade ordet följt av det minimala editeringsavståndet inom parentes följt av en lista med alla ord i ordlistan som har minimalt editeringsavstånd till det felstavade ordet. Listan ska vara i bokstavsordning och varje ord i listan ska föregås av mellanslag. Ordlistan har högst en halv miljon ord och antalet felstavade ord i indata är högst 100.

**Lab3**:

Du ska i tre steg skriva ett program som får en bipartit graf som indata och producerar en matchning av maximal storlek som utdata genom att reducera (transformera) matchningsproblemet till flödesproblemet. Korrekthet och effektivitet testas genom att lösningarna på de tre stegen skickas till Kattis Links to an external site.. För att klara labben ska du bli godkänd av Kattis på de tre stegen samt redovisa labben för en handledare. Kattis kontrollerar både att programmet gör rätt och att det löser problemet tillräckligt snabbt. Kattis klarar av programspråken Java, C, C++ och Python, men tidskraven i denna labb gör att vi avråder från Python.

Steg 1: Reducera problemet till flödesproblemet

Du ska skriva ett program som löser matchningsproblemet med hjälp av en svart låda som löser flödesproblemet. Programmet ska fungera enligt denna översiktliga programstruktur:

Läs indata för matchningsproblemet från standard input.
Översätt matchningsinstansen till en flödesinstans.
Skriv indata för flödesproblemet till standard output (se till att utdata flushas).
Den svarta lådan löser flödesproblemet.
Läs utdata för flödesproblemet från standard input.
Översätt lösningen på flödesproblemet till en lösning på matchningsproblemet.
Skriv utdata för matchningsproblemet till standard output.
Se nedan hur in- och utdataformaten för matchnings- och flödesproblemen ser ut.

Ditt program ska lösa problemet effektivt. Kattis kommer att provköra programmet på bipartita grafer på upp till (5000+5000) hörn och upp till 10000 kanter. Kattis känner till problemet som oldkattis.adkreducetoflow Links to an external site. (reflektera gärna över varför problemet heter reduce TO flow).

Det finns ett programskelett för steg 1 i några olika språk på katalogen /afs/kth.se/misc/info/kurser/DD2350/adk23/labb3/exempelprogram

Steg 2: Lös flödesproblemet

Nu ska du skriva ett program som löser flödesproblemet. Programmet ska läsa indata från standard input och skriva lösningen till standard output. Se nedan hur in- och utdataformaten för flödesproblemet ser ut.

Ditt program ska lösa problemet effektivt. Kattis kommer att provköra programmet på generella flödesgrafer på upp till 2000 hörn och 10000 kanter. Kattis känner till problemet som oldkattis.adkmaxflow Links to an external site..

Steg 3: Kombinera steg 1 & 2

I steg 1 löste du matchningsproblemet med hjälp av en lösning till flödesproblemet. I steg 2 löste du flödesproblemet. Nu ska du kombinera dessa lösningar till ett enda program genom att byta ut kommunikationen av flödesinstansen över standard input och standard output till ett funktionsanrop. Programmet ska fortfarande läsa indata från standard input och skriva lösningen till standard output.

Ditt program ska lösa problemet effektivt. Kattis kommer att provköra programmet på bipartita grafer på upp till (5000+5000) hörn och upp till 10000 kanter. Kattis känner till problemet som oldkattis.adkbipmatch Links to an external site..

Matchningsproblemet

Givet en bipartit graf G = (X,Y,E) finn en maximal matchning.

Indata

Den första raden består av två heltal som anger antalet hörn i X respektive Y.
Den andra raden består av ett tal som anger |E|, det vill säga antalet kanter i grafen.
De följande |E| raderna består var och en av två heltal som svarar mot en kant.

Hörnen numreras från 1 och uppåt. Om man angett a hörn i X och b hörn i Y så låter vi X = {1, 2,..., a} och Y = {a+1, a+2,..., a+b}. En kant anges med ändpunkterna (först X-hörnet och sedan Y-hörnet).

Exempel: En graf kan till exempel kodas så här.

2 3
4
1 3
1 4
2 3
2 5

Denna graf har alltså X = {1, 2} och Y = {3, 4, 5}. Kantmängden E innehåller kanterna (1, 3), (1, 4), (2, 3) och (2, 5).

Utdata

Först skrivs en rad som är densamma som den första i indata, och därefter en rad med ett heltal som anger antalet kanter i den funna matchningen. Därefter skrivs en rad för varje kant som ingår i matchningen. Kanten beskrivs av ett talpar på samma sätt som i indata.

Exempel: Om vi har grafen ovan som indata så kan utdata se ut så här.

2 3
2
1 3
2 5

Flödesproblemet

Givet en flödesgraf G = (V,E) finn ett maximalt flöde. Lös flödesproblemet med Edmonds-Karps algoritm, det vill säga Ford-Fulkersons algoritm där den kortaste stigen hittas med breddenförstsökning.

Ford-Fulkersons algoritm i pseudokod

c[u,v] är kapaciteten från u till v, f[u,v] är flödet, cf[u,v] är restkapaciteten.

for varje kant (u,v) i grafen do 
    f[u,v]:=0; f[v,u]:=0 
    cf[u,v]:=c[u,v]; cf[v,u]:=c[v,u] 
while det finns en stig p från s till t i restflödesgrafen do 
    r:=min(cf[u,v]: (u,v) ingår i p) 
    for varje kant (u,v) i p do 
         f[u,v]:=f[u,v]+r; f[v,u]:= -f[u,v] 
         cf[u,v]:=c[u,v] - f[u,v]; cf[v,u]:=c[v,u] - f[v,u]

Indata

Den första raden består av ett heltal som anger antalet hörn i V.
Den andra raden består av två heltal s och t som anger vilka hörn som är källa respektive utlopp.
Den tredje raden består av ett tal som anger |E|, det vill säga antalet kanter i grafen.
De följande |E| raderna består var och en av tre heltal som svarar mot en kant.

Hörnen numreras från 1 och uppåt. Om man angett a hörn i V så låter vi V = {1, 2,..., a}. En kant anges med ändpunkterna (först från-hörnet och sedan till-hörnet) följt av dess kapacitet.

Exempel: En graf kan till exempel kodas så här.

4
1 4
5
1 2 1
1 3 2
2 4 2
3 2 2
3 4 1

Utdata

Den första raden består av ett heltal som anger antalet hörn i V.
Den andra raden består av tre heltal s,t, samt flödet från s till t.
Den tredje raden består av ett heltal som anger antalet kanter med positivt flöde.
Därefter skrivs en rad för varje sådan kant. Kanten beskrivs av tre tal på liknande sätt som i indata, men i stället för kapacitet har vi nu flöde.

Exempel: Om vi har grafen ovan som indata så kan utdata se ut så här.

4
1 4 3
5
1 2 1
1 3 2
2 4 2
3 2 1
3 4 1

**Lab4**:

Ansvarig för castingen på ett filmbolag behöver koppla ihop rätt skådespelare med rätt roller. Samma person kan spela flera roller, men samma roll kan endast innehas av en person. Manus anger vilka roller som är med i samma scener. Inga monologer får förekomma. Varje skådespelare får bara ha en roll i varje scen. Varje roll måste förekomma i minst en scen.

Dessutom är divorna p1 och p2 garanterade att få (minst) en roll var (och de rollerna ska självklart delta i åtminstone en scen var). Detta medför extraarbete eftersom de båda inte tål varandra och rollerna ska besättas så att de aldrig spelar mot varandra. Rollbesättningsproblemet är att avgöra ifall alla roller kan besättas med de skådespelare som finns till hands. Ingående parametrar är alltså: 
Roller r1, r2,... , rn 
Skådespelare p1, p2,... ,pk 
Villkor typ 1 (till varje roll): rt kan besättas av p1, p2, p6 
Villkor typ 2 (till varje scen): i su medverkar r1, r3, r5, r6 och r7

Indataformat

De tre första raderna består av talen n, s och k (antal roller, antal scener och antal skådespelare, n≥1, s≥1, k≥2), ett tal per rad. 
De följande n raderna representerar villkoren av typ 1 och börjar med ett tal som anger antalet efterföljande tal på raden, följt av de möjliga skådespelarnas nummer (mellan 1 och k, kursiverade i exemplen nedan). 
De sista s raderna är villkor av typ 2 och börjar ett tal som anger antalet efterföljande tal på raden, följt av tal som representerar de olika rollerna som är med i respektive scen. Varje roll förekommer högst en gång på varje sådan rad, så antalet roller på en rad ligger mellan 2 och n.

Fråga: Kan rollerna besättas med högst k st skådespelare så att p1 och p2 deltar men inte är med i samma scener som varandra?

Exempel på godkända indata

nej-instans:

5
5 
3
3 1 2 3
2 2 3
2 1 3
1 2
3 1 2 3
2 1 2
2 1 2
3 1 3 4
2 3 5
3 2 3 5

      	ja-instans:
       
6
5
4
3 1 3 4
2 2 3
2 1 3
1 2
4 1 2 3 4
2 1 4
3 1 2 6
3 2 3 5
3 2 4 6
3 2 3 6
2 1 6 

Uppgift

I den här laborationen ska du visa att rollbesättningsproblemet är NP-svårt genom att reducera ett känt NP-fullständigt problem, som finns inlagt i Kattis. Din reducerade instans kommer att granskas och lösas av Kattis. Du får välja mellan att reducera problemen Graffärgning (problem-id kth.adk.npreduction1 Links to an external site.) och Hamiltonsk cykel (problem-id kth.adk.npreduction2 Links to an external site.). Indataformat för dessa problem beskrivs nedan. Din uppgift är alltså att implementera en reduktion, inte att lösa problemet. En Karpreduktion transformerar en instans av ett beslutsproblem (A) till en instans av ett annat beslutsproblem (B). Programmet ska alltså som indata ta en A-instans och som utdata generera en B-instans. Tänk noga igenom vilket problem som är A och vilket som är B.
Kattis testar om din reduktion är korrekt, men du måste naturligtvis kunna bevisa att den är det vid redovisningen. Kattis svar är egentligen avsedda att vägleda dig i arbetet med beviset och påpeka om du glömt något viktigt specialfall. Vid redovisningen kommer handledaren också att fråga varför problemet ligger i NP och vad komplexiteten är för din reduktion.

Vid rättningen utnyttjas en lösare för instanser av ett (annat) NP-fullständigt problem inom rimliga storleksgränser. Av tekniska skäl har Kattis en maximal tillåten storlek på instanserna. Du får bara meddelanden om den ifall du skickar in en för stor instans. Du får redovisa din reduktion om du kan bevisa att den är korrekt, oavsett om Kattis har godkänt den eller inte.

Tips

Det kan underlätta om man använder en verifikator för den producerade lösningen, så att man upptäcker om en otillåten instans produceras vid reduktionen. En av kursens assistenter har skrivit en verifikator som finns kompilerad för KTH:s datorsystem på /afs/kth.se/misc/info/kurser/DD2350/adk23/labb4/verifyLab4

Verifikatorn förväntar sig att få utdata från er reduktion på standard input. Kör verifikatorn med t.ex.

/afs/kth.se/misc/info/kurser/DD2350/adk23/labb4/verifyLab4 < out.txt

där out.txt är en fil som innehåller utdata från er reduktion.

Graffärgning

Indata: En oriktad graf och ett antal färger m. Isolerade hörn och dubbelkanter kan förekomma, inte öglor.
Fråga: Kan hörnen i grafen färgas med högst m färger så att inga grannar har samma färg?

Indataformat: 

Rad ett: tal V (antal hörn, tex:\displaystyle 1 \leq V \leq 300) 
Rad två: tal E (antal kanter, tex:\displaystyle 0\le E\le 25000) 
Rad tre: mål m (max antal färger, tex:\displaystyle 1\le m\le 2^{30}) 
En rad för varje kant (E stycken) med kantens ändpunkter (hörnen numreras från 1 till V)

Hamiltonsk cykel

Indata: En riktad graf.

Fråga: Finns det en tur längs kanter i grafen som börjar och slutar på samma ställe och som passerar varje hörn exakt en gång?

Indataformat: 

Rad ett: tal V (antal hörn, tex:\displaystyle 1\le V\le 200) 
Rad två: tal E (antal kanter tex:\displaystyle 0\le E\le 5000) 
En rad för varje kant (E stycken) med kantens starthörn och sluthörn (hörnen numreras från 1 till V)

**Lab5**:

Du ska välja att implementera valfri heuristik som löser konstruktionsproblemet: Vilka skådespelare ska ha vilka roller för att lösa rollbesättningsinstansen med så få skådespelare som möjligt? Indataformatet för rollbesättningsproblemet är detsamma som i labb 4. Divorna är 1 och 2.

Utdataformat: 

Rad ett: antal skådespelare som fått roller 
En rad för varje skådespelare (som fått roller) med skådespelarens nummer, antalet roller skådespelaren tilldelats samt numren på dessa roller

Problemet ska lösas enligt villkoren som specificerats för rollbesättningsproblemet, dvs divorna måste vara med men får inte mötas, ingen roll får spelas av flera personer, och ingen skådespelare får spela mot sig själv i någon scen. Bättre heuristik (dvs färre skådespelare) ger bättre betyg. Endast lösbara instanser kommer att ges som indata, men för att heuristiken i polynomisk tid säkert ska kunna hitta en lösning så är det tillåtet att använda högst n-1 särskilda superskådisar med nummer k+1, k+2, ... Varje superskådis kan spela vilken roll som helst, men kan bara spela en enda roll.
