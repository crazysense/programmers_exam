package hacker_rank;

import java.util.Arrays;

// 문자에서 공통 자식의 개수
// LCS 알고리즘 (최장 공통 부분 수열)
public class CommonChild {
    static int commonChild(String str1, String str2) {
        int lcs[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }

//                print(L);
            }
        }
        return lcs[str1.length()][str2.length()];
    }

    static int commonChild2(String s1, String s2) {
        int[][] lcs = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) lcs[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }
        return lcs[s1.length()][s2.length()];
    }

    static void print(int[][] L) {
        for (int i = 0; i < L.length; i++) {
            System.out.println(Arrays.toString(L[i]));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(commonChild("VGXGPUAMKXKSZHKBPPHYKINKEZPLVFJAQMOPODOTKRJZRIMLVUMUARENEXCFYCEBEURGVJYOSPDHVUYFVTVNRDYLUACVRAYGGWNPNZIJDIFYERVJAOALCGXOVLDQFZAORAHDIGYOJKNVIAZTPCMXLVOVAFHJPHVSHYFIQQTQBXJJMQNGQJHWKCEXECMDKMZAKBZRKJWQDYUXDVOOSSJOATRYXMBWXBWEXNAGMAYGZYFNZPQFTOBTAOTUAYXMWVZLLKUJIDHUKZWZCLTGQNGGUFTUAHALWVJWQNCKSIZGZAJKHYJUJLKSESZAFZJMDTSBYLDHYLCGKYNGVMHNEQYJDUGOFKLITXAOYKFOQKZSZNJYARKUPRERIVHUBPEHXMOYDAKKLBDNFHFXAMOTUBELZVBOZJARAEFMLOTFTNQRJOLVUAMAHNDEKFDSQCFVMQBOCBOMJXRQSFSKEVFXPHCQOQKBBOMCYURWLRNHRHCTNTZLYLVWULBDKCDPPGYKICHJTPUKFNLXFCEVKJEZQSMEYCANJLBESSRFAZDPRCOMDPJIMSFBUSLKSYVEERGCGMONCTCSVYPOLPLCGSQYFKILRIXODIWQCYREIWKRPIUIASFKJEXPFTZNQIBLSRJUYFSKNDAPWJEFUCDQCIUEHVFNDGHRXXNMVZLJXIOYUNDVPNDABSBNWOEYOMRJDCQCRXVYAHERMUDCCMUEAHEBYVSAKXWSEQZDUYFEZUJAFFDRSQFSEQSDFCGDENMRFWFNDIJTEPXHNVEDFBAGZRXKPRTGBOUKFXIWHFZFKSNAWGCUBSPXSIUYTQRWMVXFSVZLOTLFWIMLIYGNFDDESWMXUVHNQVJZGKPDZFJMCJCMSAASKEXTLSJRGGTYCGCQFPOQOMROUHJKNTQRYHJIFCXBYWHFUTFZMJCDLIVNUXMRDFGHKQLQZAEEAZKOOMVPYSJWNCYQYABUTSITEZURQHBUWABEXRCUIWAFNFVCASMRMBQNUPRUSKHSMEICAQQESYYVOPEPMVDOSIBRVQOGHDEIKBPQBFGRUFXDSQCHJKUXPXNGEBXRMQDGQJSOSENCRBWKNLLVUCVUBYOZFMTTXTLSRRNRQAVSHASZRENHLBZPNPJGQFTVWGUKJWSEKFCGLLBZLNVMOSMVQUBTWSGLTVMMZMSLQDXQIIFZKAQHSXZGUSEUEXLYCGUBHDNWHRSSYIYBITCOOWLHMMRDPGTRDWALVFFKNWIBHWHACQFJCMWUPOXONAVVXWSVPRPYMSKZNABSQUWSSUCXRMYWERFPZIQDZIYCNYNTHGMDAVYBZBQGCRGVWALCPTUTZXSQLKCHITHCDEZSAEFLDDFLGTIXBNAGKQRZESCKRIHWQPLFPSPKQVIFBMNQWIDBKZQIYGWFUNEFIWPXUEUMDWUGBFGNOJJRJPAFGKIRRUEOEZABCQLZMCDWMKLVYZVUUGHETWKXZUZFVOIRAREYBLWPRDNETKYIGXYQPZXECKYGYXTHSZXGYIDGLDNLZEQNDBVACJQYHFKQVLIUSQMXYEQYQORZMMJWSUICNYXQNKTYLAQNVBJLLTEXGRHIFDNEUGYSZNCRWGIDCFJGDZKOQFQBWEUCHTDVPIUNKPEHCSHTMRENTGSNDNBTBBBMOGUOPYPWKAPKRWISAMNXAGZFQSFSXTYXEPBPUMTLUJGXUENMZGGJMGIUTQOELTNLYBOQJEGCVUUIILMSBNALVBSFUTYARENKEWZLPWGQZFNNKEXXDSUFCJVRBKESROBOSUZUMUCCGMRSMXZTPSIQCHFCLVZKMVFMUSCNBRLCZVFZWMMKTUSAJDHOCMPRJLNDYDXROJJAHOCITARXLQXQJXQHPFZEWPYYKZEQJPEHSGIQVYEZBQWNPYUCIOBBLOXJXUOZSUVQWPHLHGLUFBHJGBPKXJXIYEUWMDUSFMLXKVQSMWYTKJOAKBNPGPHEFWPQNRBXWDAIPPUEOLNGEDDTRXPAXXZIWPHXKEINQSDIVGPLBCSZJHSXEICKSXBSEJHGMKIHTJCQQWXFTJSWWPTMGZPTQNOIXWPARKLAYJDSBIJTRGTXGZFCPUCHDSMKVQRHGDIIDNNUNWSXSCQQNNQMPCPKAGZSXMCBORWJYQNNOUSXHSDMKLMNDNTFUKMSKHNFJNFRVHQOMOFZKQIPTSIHALUJJXKBURWSBDLLAPWRQCARXMLZQWFCALVWXJFLFJTSTVRCTLBKBSJPNXYHSCXDXEPBWQECEWRZCITMDFBWZHIOWCPGGBUNWIOPNJDJCWRMIXZQULDIALDWRDJMBHVKGQYSPROVNZFRBAJESSMYBYCKDQMSXSRYDSKOIKTYFXJOMBTWYSKCTDJFQUVEKMCKRWIVZAYCTXCFXPTGRUPRMPNZSWUOEGWGDBBYPIRUISJQIBACPBOMBSJOQOZZSDGDRGYQYRFRKSSNTFGUDFQRQZXECGUCLNXEATMLQXSJKYJXIFIRSWZUDOLGMNLJJZJUJUAYJIICCERVHAVVGTCWHLSRWAQOTOGOKHTWGJMFQSLVHZPGNSFQHGBOEHMZPONRTKQJUANPNUFNLUEZLJSQVTOFMENWFZLGRRPZETXOGOBQRHUHLYGENSBKPWQBWWCZNXEIYOZTKMGCVJUSURKTIEHAHZRNTRRASIKBABWCSRHACZNXYUDGFPQDPGUIJAWGHWVVFOGDVTUHMORJCEOFCTZQYGFIETZKBEGKBSJZMFZRMFPMGVOAFXFYINMAYUXCJREDRYDNVLXWVHUEAIQGLUUFBBDTPVTCFHPRLYRBVVLNTRQZMQAWBSSRANJHAXTJVSXSDUOZSXLOEBLCIFBYFEUONSYRICVCCFPKZTIOALHQHQEKYDZQXMNZCAPLZLYXVFBPDZMLSFMMLGTNFRAROEBTFDUZXGPSAQWCNJIYTSRZYFWKRDLABYWHCMFGZVCYBFLKACYHHCKASMBLHBDJEOJNFWYLCQVNBMZXUGFSIYJGUICGFFIWRSZZDBZJYHVGPNFSAPUFJQFESPXBFLJGTDGSMFEECQFWFVKWEIACDITMSNFALDCQLRYCLLMCCMODLNLBKWVGMDZWAPSBZYRWXASQVCTBMTBPIDEDMVRPXQNDCAHLTGZSHJARUUEMQUXRRVTHOHCDKUURWURKWEXHYPSBUPXUISDESHLTSVFHVJVHNXGGARVCDAIIAQADYJJERNIDPERSJDQUCSAUPRZTYFOIIKLHTJSZNDDFTCGELCHWBIZHESDUXMACMZILDECEGSHHNTFZNBBBGXAVMPNFLHPXYLXKYZTWBQWPUYMQLNXMETGHTNREFEYPIVPYNDOBBRESGVLMKKXWHLOMIGIRIZLNGKYKRYMHEYWUJWMJHNZXMGMKQGSAJKYKVQJYAPLNWKCUBVBXDXYHECCRZFNEHQEIZVICXXXESNSSFEUZHSJDHXNDDSIUVXANFKPEQODIRLSYWLYMIWSHVENLIUOMFLSYIQACJUAJHXMEKLFADFVXVMPKNEDSHBYVENBOQUEAAIQWEXNQGQVJWZFOFOKVKGDGZHWRTKTDBERAPDNUMYTFOBBQCOZOJIVHKNGVYYSTJGSDFNOSJLRXPZFENFYHWAJCJUPUWYUVKORVMIUPLWVOOOJCKJMAQYSPYACDNGDNMUYRSOISLCMORSFGZZKSPOSLTNXPVOHDSPMZKEWHWNJMMMGIQUYWBYJIOWEWRVFLTAJJRDUGEJYJRKWAZOGERWKHVGTQUXUXHRUBFRQYFARBIAEPORGWQUIJHBUWQVEJGCOJNCYUOPFGFPTTEUSXAJVQYNZZISGNXJHJETOMWBTTPGBSZZUWRFNORZXTOMUWNQPKUTTCBYBDHLUVCEXTUOXMZGIBULSZOBTMXUTCCLNYXCDFHZNMWHESGEZPVXPYCZLCGYAQNKGIJUKIIIUCJFUEQBMXQNWDCYBERSZMOFRWOCLBYNJWJCRQAYJPCIJNDYZMCTZBAOQEUGWRMHPKZVYYGKOVPCKBZETSHNEBUHTMQQPMBWSEOCXEOBHDJMKFMZVMKEZWOMLYZPAGRXGXYBZTSXAEUNETDTIKJBBXUQJCDWYHWREGFYJHCTUARLQOFGWHPYUTWRBYEBFSSWBRCZWXKLTZJGMFUXARYDAGGOJPHEUSIUBPMQJMHOCQMVJOSPDFLIVMSRCQTWGXDAZUNYTIFHXQUASVCGDLOZUQZWHFSSRCXARCJFLFTMWNGZONWFSVTUKXVBSOUBBBPBFWJFNGELEKPMOADIZDSORTKABMSWCMYWNBAJXNKVMNDBVTCPNJXWMODDNTSQTHUSVZMKUEDBDKBIQDWPWPSSRJJFLSWUFMHCLMNSTZUBTCVQVQSDSSGSCJYQZWCAMNVRILESSQPZGQXDLSNCLUJDSAQBXXYLTZLQWLUORTKQADJCQUQDQCSVIXGWGLWRRMKHDSBEBBJVCGZLWTBVASPHVMNFVFJYKQMIMWXEMMAHHMZOADAPWORUVLPQOLWBMKESKAFYZBVZVMMPRWAXISDUKVMBVCVZWXYNRTKSBDZKVAGIHFGIQMSDEJXIRROWIRGQVZELYSOHWVJFALSGXGZOKBFURVECUXSIPQVRWQJOSFYBNCIHPZJCBXEFZVRIISGFIPSIAPDPBSSGLQJUHVQRXEFPTIMXEDAHMJQTVIQRXNFPOYSAKXHXRJETYDSXIXVXYUJBVQAVXZUPQPZDQLNDDXFANWNKTLPJCCPWUYGXYYXUAFYPZOAKDXPKAHVPJJFDOGNZBYIXYBMKDAQLIXEUTOJGTDJLTWPXPVUMBUDCKMDXRHQWKRRLLTGXDYOAOKDPARWBANIDRFSSIUIGZDUWZEJBBNUOIWQLSGTESHSCNVLMJYIWHAGTIMRQTFFKFGBODLWXIRGRMRDHLIHYAMXMOLBYFWCDPUTEDZCWSKRPKYKQYPKSLSQNFNDIGWHJPDQMACLGNEBLKQCEPSNLJBYOYXCHDIYYGWCHTCOXYZZBLNCVOSGCFFRHAS",
                "EVYRFZJIZJBKRFPPCJBHDPBYICJMVXNSXRLFUPSNIYCHUTSVGWTRJVNEPWFSSFOVSAXKHENZIDOHUQRMXXUMFDDYGFEYPTZCOURHVEDKDOACAMYUOYEINZLVOCYDNXYKXPFKXWMDOCFZGCBWJJZRJZVSLTCPVUHZNZLVNZBDQYJXQWGBTLLQADGXJFZRTMMVBDKCZRKYLNZEJAIPLDLCTXVKLOFQNQFFKYDZGTFBFERGKEQMCVYLZQIIUOCWGDVICASICRUGGKBSRGYLDPIWKURUYIHBERGCGGXWUJDPROKXYKQQBUITESPOHBQNKQKUGWHLHKGABAPHQTFDBFHGVBLUYXWZOPSQEUKCLFKFWKXQWZAKBWBHILYFKYOIITLSHCNCYQDMJNFJEKJJDZQSWMJVNDTMYANVUCNZBDUAMHAPYNGGABONFABHVNQMKSNYHYYDLHKFHHDKHVSUSNWPPWDWVAYFKSMBSXUJUVLAIGWMQSNZYTVWBPLYYDSPRLUCGXOAAJLLVQIIHBCKZLPASFSNSUSYFHBMCBFOSTWISFNREQQYTKDCAHMKZTUAXOJIFTFVWWVMODLJMNBJEOIFEYNMAXZKTXXPEDAGSNZUVFRKIGJDCKUZOSKNADBFLGISKPPHYGXZMCMFAZJXAZHBQBQRREZXLNIOKHFKKPDRHTCRUEQXLXXDCVJLXISJXAWESPGXOXJYGEOQZEMXIKVPQRFQBXYARJWOJEKEXBQAEDYUIPLLDVKYKWPWMZHEIQGDNKSFYMIUINMORLIZMXMLHXSJOTKROYPHYKJHRBEXHAFVCJETIIMMPQKSPSPLOAYAPWBXUJWJBBIHVGVKDCFPABBAYMCZPIMZTOQBIDTJSDNKGUDECSFSRREZFBTUXIXJKIPXTNCFQUQDTANIWLEVDYODLIIWUVBOGQZWWPURCQVRYSJZDBSUCBXNLKFGCVWAGOIQIGSNVKWEMYBVXUAERMVJJLDZSPJKPVEOFJVPVGVOKSJYIFNLGBRUBYVNDYNHVLUDRYLJRGBKYSZBXNVDBYAHLZTQXUIBBOTBFKHSGYKPGCRWLMXZMHIOVKLIJTBUTFDIOJSCLMCJTTAFLMSYDWUNHEIKKSKJHXADKTUYNCEYAJDKVEIMKSQWLOGDYYDDKSRARLPGFZZNZUAJFRFEUNQJUAWJHFMARNJUIYEUZTDVRZHCEZVSFKHCDGTTNPFNKHSYPMXBOBNQYLLOAKFKNOYPEORITDIQRKMJIFOUEIBYCUXNQNUNBTNLNKCIOHEFUQCYFOBIIYBUWPRQRFOKONIRFILFQGJHFPLYASYJMZQPDWTSBKGQCYUVTBUNQNHNAEFGPJNVAGTPXFQRGMXTSVAJTRPBDBNZQACKJDTAMMEUASETGWFZWBYSFOMABHMXHLNQTBALMJFHXROGODUKWEYZMJFHKIIATYPLTUNTSXAJRCDZFJWFXRQWHPOSVXEDXOMRDMBQHAVOCMVTKGGPULOVCCKLEYCFGTYPCNCNHTWUWRMZJPBSCIMPXCZRPBIXQVAMEGSEYPGECDDFOFLQTASXNGKYWTAIRATEGYVZXTTVBFDDKWXOBEZXFNWPZXKJCDPNLVWOZNDNFEGUHYCDOOMTXBPIQLQWOTOIBBQZWXVGKMQWOWATZOZGBTRDKNDCPIVAILDYXKKNZYIYYTBFLWPAITVIRSPTZDHLFSIABOMDXQHTFNVLEUOUKTABUAWPRTURPUMHGKBUACFFFOXRIUGZAQSENYFNMGQJMSJVOBAEUQKGWPYVWPAFBNXIODTCEMCDQAXVLNYCQYVAXXYBHVDKHIUHPVUMQBFRYWTQKUVJJEAEXYCJZHRFCLDUGQRVIYLXUBXWGTCPTVELFADQXBCVTSEZNBBUAEUDGEJCVYTASTWCZYJQHGLYHZTGDDICBNLVYTJHMHENXSDHVLYFLHZQSOIDECOJQGXSQKHVFKPLDTOQYRGADZGIOOLYNWZXJRUIIYBWCNWAUPWGMUEQDFYVSVLBHQQXKCEEBMWQJYPIYGYZCDBZPKYRHROJQMQSBJILAMAKICREORUIJZRHWWFKBVZUAJRSCCDHBKUNZVWRHSIPHMBDAMNNQKHTFKYQRDRCEXZFTUAXFRPHOIPMZXCZJCUOQCZGPRMZIOTDISOSKROXJKLEAHTIRTMVEUCAYQVJBJCRNDJVXVVOUMPCGCZWUMAAPDEPSHNAIMATOLVNLMEPBJZWXMACWILFYKKKUYSUCCMFTJUOCCUPAGBYAKRUGNNSGRVBXDWGTQZZWHBKYJDKFNIEPBOLVIWSBEVYPMEKZMEVXOHKSLYLOSUSKCVEHBYRRUYKOHNENCVYODSTLPWDWOOONHNIYEGMYEKMTOPUWYKWCTHHDWZQXOCNQGZMTCTBPUILLKMAWSSJTRGXLSPQQYCZVKHHFCUGLIDEMBZUNQFSPCPHJQTUAYWQBJJSQYDFOJZOFIRJWOIOBXHFDIMSVISXEYYRKSQALVHUQLQOJZVDMADAIUKMJQGFAFJQOYWDFXPMBUOXOEISIHWBLFTQBSBCMQSKWMHNWOJRJOOAHBBKCVKSOGUCZQZVRPBMDKQYICBHJAZSCXKVRMBXHUGUZXFEJGUIANOFATRARRNZPYVBLJZTDZLRFIZBLVXKJRFACEVLDDQMRGZYUHJFBVPVLZJFNBKPKUFNAOEJEQNSNKITMIGJVIBPVIJTBEVSSVLCQZMSHQNDHZHXGGCTDZPOGABKKJTNIXVVGXHKRYILLFJMJHNKKDIQWGPPVJVCBWEQOVKIDJEBMKOLZGSLHMRHIQGLVWHICMTOXPITUPETITSOBUIWYRKMZMWFMSGFOORVZEBZPVBSCVETJKNHNQTJHNINAVAWQHPKHBCSAGDNLYAADUSPPTMGECGCBYDSMNGFPLHLMEQPDUYJVIRVRZFBRFMQKEWXOTZGTHMVBXBNUYACTBIRPPWWYMERCDUZTLKJJMXGBHFINZEEZPOFNCRTDYCEPYBZWNHKZXKNJNOTDVKFKXWKWOBTKAWEBEZAJMLPFUXOAQMEEAPDEWVJDVHMJIFZVPJKAZWPCVLRUWWXATRFIEKSQFVFIGJWYTMBMLLCQPQJNELFQLBCGLODVHXBWJNTQPKEMPRBWNAVCPJWKCIEKOOVBCMSLERUKVJCQAIXQBCHUXCDIQCSOTCHLQBYAXHWAJAFWZAQMHRTXMFDIWFFYQTVVSWXGIDAOHUHDQSYMOZESUHIEHBBCHTPTSBKBWVRSVNDQYSXMWNDBAECMHPOPMSAUCXOHITLWDNCPBVMKCUDAJESJBGMVXVTPBOOPAEGUGLKUJIIZPQPQVYPIBOOOBDOJUFCVEWMZMADYLIHDJJYALDZXDYNFCKNHQBIJHMAJWMYIYKCNGPRIVZMOUZRXRFVMZSDHAQJEOGJYEJIWHZSEHQVUBFNEFKFLTAFNFCDXNMJIXQNOPGMYVZUVWUFVKFXMYCBBQIUBWEVLYJHDSMZEDRJWVLPVCXJLPNACMEHOWHRJIEEXEAVAHUQYRYHEGRGDBHSGQAHFIIHVPSVXGQJRGOBNTLFILNFPMIDKEHUQBJHCKHBCWEWFAIILHINFVDOJBDLPGNPRTORKRMMCZNCYWFYDRTUYOTFRMZVPHRKKTERJKIJUWCVJANXEQWCUIXLWFUEGNPHHKELAKDLTQEEBMUUQHEJPOBTDLYRFBZGUOKCWARIBQJCUUBQLYRUMVCRGTEIYUDJIDIPZNNGMPNFIONDGFQGPEQPGEKNHEJMNTASLYRZUYKRIIERZLIDIHPEBYIBUDVYNXGVVKLOQPDVRNYLINDKNAEHTDIOLSUFZGOXGOFOFURIVLOCFBPGCYOCVBGFMKALQZNBKWNZPKIQWRLIMNKBBXJPQHCTUXAHUQTFBRBKDAFALDVVZRRPLOEVUCBUDBUUUFWFGBUWGKAKDRYCBVLOSSJZHSCYIXWOYBDUWSBFKSHSKVZLBNDNHNCZSKZNQIUUUYNVRDUPFJORXZDEVVRNGHYBKQEANYEYJDCQXPHEKNPAKRGZTODMNJKQZAICVLWCIWYDFSRDDBGVFKCOCZAZKDUBFTKLNYPTMRKJIOKPECEIBEABQGCKLJYMBIACXYPKNGHOKWBIPGLAXBVXKWCJCDGHCKWAZBRDFRNTZBZVCTXKTQNXTNGQWVAPWVLZXPXCSIOJWHWTZYXLZUSVTRYNJXQZBBVZXFBHJCDAWJAUJUUGLNTLCNIGZINJUAZHHOZCTXPCRNSMQBEEZWHIBSEAFALDETCFKCVLMQCCLZIVVZUMHGAEPAIFGSCINZQJEDNTSYGVTWSQWREKGFEUSLRZYXXTXABLAWYWMPYFXBIGRRITWTELCILVQRNWLJMNBSCILFZOUJGRGQWZDGXZWSVKVWQTMUKXZDCYDENZNEIMHXWYATJEMDEQTXYPMVFEKHSPZFXHYKPGWLSJCDOBYFGEUGOVJNXOTXKDHJTIFFTJWHHDXCNWOLPHGOHJORXKQUCTLSDMGSVRDUPWVZRUSEDIOMVFSYERIWIXVPSMHIISMNSWPVAQEIXIRJNABCAPOHKXTFXZANQJUSTEAOCTNXACBOTRLXHGLSXMHMATZXFLTFJDAIYSQSZEJUPSBRGFEGHBWIJAVFINBBCFQRPUTGARLCNJYHZIADZPSUBZPEYPEFLUGWPGIFNXTGBJCGRLVVBMDKLGNYPLZBXZQSSQYLZZTKJLNMXMSLBOCOXQPGDARJAFTDZCVJSPXXIZQIEHGYOBWULEYAZGISEMUWVNCIPBDJCLIWBCPKZKPUQFTITGLWJTLHALWOUYGHRGJWRCNNRSAELAKVVUXUGYMUKRJBYFKYENHZBDTQEBVLTGLCJSEJWJUZCYNCMRIUQNNCNIAGCTKLFEZDFWKHLPIWZCZGHYCJLJQWVKMDNBJNKIZWBWHQWPPJNREFYQMCDUGXMDDRUAYHZUNFGCKDDZSJAKIEYZCZRHEFNJXLISNBITZYWZEDQNQCPAXPTG"));

        System.out.println(commonChild2("VGXGPUAMKXKSZHKBPPHYKINKEZPLVFJAQMOPODOTKRJZRIMLVUMUARENEXCFYCEBEURGVJYOSPDHVUYFVTVNRDYLUACVRAYGGWNPNZIJDIFYERVJAOALCGXOVLDQFZAORAHDIGYOJKNVIAZTPCMXLVOVAFHJPHVSHYFIQQTQBXJJMQNGQJHWKCEXECMDKMZAKBZRKJWQDYUXDVOOSSJOATRYXMBWXBWEXNAGMAYGZYFNZPQFTOBTAOTUAYXMWVZLLKUJIDHUKZWZCLTGQNGGUFTUAHALWVJWQNCKSIZGZAJKHYJUJLKSESZAFZJMDTSBYLDHYLCGKYNGVMHNEQYJDUGOFKLITXAOYKFOQKZSZNJYARKUPRERIVHUBPEHXMOYDAKKLBDNFHFXAMOTUBELZVBOZJARAEFMLOTFTNQRJOLVUAMAHNDEKFDSQCFVMQBOCBOMJXRQSFSKEVFXPHCQOQKBBOMCYURWLRNHRHCTNTZLYLVWULBDKCDPPGYKICHJTPUKFNLXFCEVKJEZQSMEYCANJLBESSRFAZDPRCOMDPJIMSFBUSLKSYVEERGCGMONCTCSVYPOLPLCGSQYFKILRIXODIWQCYREIWKRPIUIASFKJEXPFTZNQIBLSRJUYFSKNDAPWJEFUCDQCIUEHVFNDGHRXXNMVZLJXIOYUNDVPNDABSBNWOEYOMRJDCQCRXVYAHERMUDCCMUEAHEBYVSAKXWSEQZDUYFEZUJAFFDRSQFSEQSDFCGDENMRFWFNDIJTEPXHNVEDFBAGZRXKPRTGBOUKFXIWHFZFKSNAWGCUBSPXSIUYTQRWMVXFSVZLOTLFWIMLIYGNFDDESWMXUVHNQVJZGKPDZFJMCJCMSAASKEXTLSJRGGTYCGCQFPOQOMROUHJKNTQRYHJIFCXBYWHFUTFZMJCDLIVNUXMRDFGHKQLQZAEEAZKOOMVPYSJWNCYQYABUTSITEZURQHBUWABEXRCUIWAFNFVCASMRMBQNUPRUSKHSMEICAQQESYYVOPEPMVDOSIBRVQOGHDEIKBPQBFGRUFXDSQCHJKUXPXNGEBXRMQDGQJSOSENCRBWKNLLVUCVUBYOZFMTTXTLSRRNRQAVSHASZRENHLBZPNPJGQFTVWGUKJWSEKFCGLLBZLNVMOSMVQUBTWSGLTVMMZMSLQDXQIIFZKAQHSXZGUSEUEXLYCGUBHDNWHRSSYIYBITCOOWLHMMRDPGTRDWALVFFKNWIBHWHACQFJCMWUPOXONAVVXWSVPRPYMSKZNABSQUWSSUCXRMYWERFPZIQDZIYCNYNTHGMDAVYBZBQGCRGVWALCPTUTZXSQLKCHITHCDEZSAEFLDDFLGTIXBNAGKQRZESCKRIHWQPLFPSPKQVIFBMNQWIDBKZQIYGWFUNEFIWPXUEUMDWUGBFGNOJJRJPAFGKIRRUEOEZABCQLZMCDWMKLVYZVUUGHETWKXZUZFVOIRAREYBLWPRDNETKYIGXYQPZXECKYGYXTHSZXGYIDGLDNLZEQNDBVACJQYHFKQVLIUSQMXYEQYQORZMMJWSUICNYXQNKTYLAQNVBJLLTEXGRHIFDNEUGYSZNCRWGIDCFJGDZKOQFQBWEUCHTDVPIUNKPEHCSHTMRENTGSNDNBTBBBMOGUOPYPWKAPKRWISAMNXAGZFQSFSXTYXEPBPUMTLUJGXUENMZGGJMGIUTQOELTNLYBOQJEGCVUUIILMSBNALVBSFUTYARENKEWZLPWGQZFNNKEXXDSUFCJVRBKESROBOSUZUMUCCGMRSMXZTPSIQCHFCLVZKMVFMUSCNBRLCZVFZWMMKTUSAJDHOCMPRJLNDYDXROJJAHOCITARXLQXQJXQHPFZEWPYYKZEQJPEHSGIQVYEZBQWNPYUCIOBBLOXJXUOZSUVQWPHLHGLUFBHJGBPKXJXIYEUWMDUSFMLXKVQSMWYTKJOAKBNPGPHEFWPQNRBXWDAIPPUEOLNGEDDTRXPAXXZIWPHXKEINQSDIVGPLBCSZJHSXEICKSXBSEJHGMKIHTJCQQWXFTJSWWPTMGZPTQNOIXWPARKLAYJDSBIJTRGTXGZFCPUCHDSMKVQRHGDIIDNNUNWSXSCQQNNQMPCPKAGZSXMCBORWJYQNNOUSXHSDMKLMNDNTFUKMSKHNFJNFRVHQOMOFZKQIPTSIHALUJJXKBURWSBDLLAPWRQCARXMLZQWFCALVWXJFLFJTSTVRCTLBKBSJPNXYHSCXDXEPBWQECEWRZCITMDFBWZHIOWCPGGBUNWIOPNJDJCWRMIXZQULDIALDWRDJMBHVKGQYSPROVNZFRBAJESSMYBYCKDQMSXSRYDSKOIKTYFXJOMBTWYSKCTDJFQUVEKMCKRWIVZAYCTXCFXPTGRUPRMPNZSWUOEGWGDBBYPIRUISJQIBACPBOMBSJOQOZZSDGDRGYQYRFRKSSNTFGUDFQRQZXECGUCLNXEATMLQXSJKYJXIFIRSWZUDOLGMNLJJZJUJUAYJIICCERVHAVVGTCWHLSRWAQOTOGOKHTWGJMFQSLVHZPGNSFQHGBOEHMZPONRTKQJUANPNUFNLUEZLJSQVTOFMENWFZLGRRPZETXOGOBQRHUHLYGENSBKPWQBWWCZNXEIYOZTKMGCVJUSURKTIEHAHZRNTRRASIKBABWCSRHACZNXYUDGFPQDPGUIJAWGHWVVFOGDVTUHMORJCEOFCTZQYGFIETZKBEGKBSJZMFZRMFPMGVOAFXFYINMAYUXCJREDRYDNVLXWVHUEAIQGLUUFBBDTPVTCFHPRLYRBVVLNTRQZMQAWBSSRANJHAXTJVSXSDUOZSXLOEBLCIFBYFEUONSYRICVCCFPKZTIOALHQHQEKYDZQXMNZCAPLZLYXVFBPDZMLSFMMLGTNFRAROEBTFDUZXGPSAQWCNJIYTSRZYFWKRDLABYWHCMFGZVCYBFLKACYHHCKASMBLHBDJEOJNFWYLCQVNBMZXUGFSIYJGUICGFFIWRSZZDBZJYHVGPNFSAPUFJQFESPXBFLJGTDGSMFEECQFWFVKWEIACDITMSNFALDCQLRYCLLMCCMODLNLBKWVGMDZWAPSBZYRWXASQVCTBMTBPIDEDMVRPXQNDCAHLTGZSHJARUUEMQUXRRVTHOHCDKUURWURKWEXHYPSBUPXUISDESHLTSVFHVJVHNXGGARVCDAIIAQADYJJERNIDPERSJDQUCSAUPRZTYFOIIKLHTJSZNDDFTCGELCHWBIZHESDUXMACMZILDECEGSHHNTFZNBBBGXAVMPNFLHPXYLXKYZTWBQWPUYMQLNXMETGHTNREFEYPIVPYNDOBBRESGVLMKKXWHLOMIGIRIZLNGKYKRYMHEYWUJWMJHNZXMGMKQGSAJKYKVQJYAPLNWKCUBVBXDXYHECCRZFNEHQEIZVICXXXESNSSFEUZHSJDHXNDDSIUVXANFKPEQODIRLSYWLYMIWSHVENLIUOMFLSYIQACJUAJHXMEKLFADFVXVMPKNEDSHBYVENBOQUEAAIQWEXNQGQVJWZFOFOKVKGDGZHWRTKTDBERAPDNUMYTFOBBQCOZOJIVHKNGVYYSTJGSDFNOSJLRXPZFENFYHWAJCJUPUWYUVKORVMIUPLWVOOOJCKJMAQYSPYACDNGDNMUYRSOISLCMORSFGZZKSPOSLTNXPVOHDSPMZKEWHWNJMMMGIQUYWBYJIOWEWRVFLTAJJRDUGEJYJRKWAZOGERWKHVGTQUXUXHRUBFRQYFARBIAEPORGWQUIJHBUWQVEJGCOJNCYUOPFGFPTTEUSXAJVQYNZZISGNXJHJETOMWBTTPGBSZZUWRFNORZXTOMUWNQPKUTTCBYBDHLUVCEXTUOXMZGIBULSZOBTMXUTCCLNYXCDFHZNMWHESGEZPVXPYCZLCGYAQNKGIJUKIIIUCJFUEQBMXQNWDCYBERSZMOFRWOCLBYNJWJCRQAYJPCIJNDYZMCTZBAOQEUGWRMHPKZVYYGKOVPCKBZETSHNEBUHTMQQPMBWSEOCXEOBHDJMKFMZVMKEZWOMLYZPAGRXGXYBZTSXAEUNETDTIKJBBXUQJCDWYHWREGFYJHCTUARLQOFGWHPYUTWRBYEBFSSWBRCZWXKLTZJGMFUXARYDAGGOJPHEUSIUBPMQJMHOCQMVJOSPDFLIVMSRCQTWGXDAZUNYTIFHXQUASVCGDLOZUQZWHFSSRCXARCJFLFTMWNGZONWFSVTUKXVBSOUBBBPBFWJFNGELEKPMOADIZDSORTKABMSWCMYWNBAJXNKVMNDBVTCPNJXWMODDNTSQTHUSVZMKUEDBDKBIQDWPWPSSRJJFLSWUFMHCLMNSTZUBTCVQVQSDSSGSCJYQZWCAMNVRILESSQPZGQXDLSNCLUJDSAQBXXYLTZLQWLUORTKQADJCQUQDQCSVIXGWGLWRRMKHDSBEBBJVCGZLWTBVASPHVMNFVFJYKQMIMWXEMMAHHMZOADAPWORUVLPQOLWBMKESKAFYZBVZVMMPRWAXISDUKVMBVCVZWXYNRTKSBDZKVAGIHFGIQMSDEJXIRROWIRGQVZELYSOHWVJFALSGXGZOKBFURVECUXSIPQVRWQJOSFYBNCIHPZJCBXEFZVRIISGFIPSIAPDPBSSGLQJUHVQRXEFPTIMXEDAHMJQTVIQRXNFPOYSAKXHXRJETYDSXIXVXYUJBVQAVXZUPQPZDQLNDDXFANWNKTLPJCCPWUYGXYYXUAFYPZOAKDXPKAHVPJJFDOGNZBYIXYBMKDAQLIXEUTOJGTDJLTWPXPVUMBUDCKMDXRHQWKRRLLTGXDYOAOKDPARWBANIDRFSSIUIGZDUWZEJBBNUOIWQLSGTESHSCNVLMJYIWHAGTIMRQTFFKFGBODLWXIRGRMRDHLIHYAMXMOLBYFWCDPUTEDZCWSKRPKYKQYPKSLSQNFNDIGWHJPDQMACLGNEBLKQCEPSNLJBYOYXCHDIYYGWCHTCOXYZZBLNCVOSGCFFRHAS",
                "EVYRFZJIZJBKRFPPCJBHDPBYICJMVXNSXRLFUPSNIYCHUTSVGWTRJVNEPWFSSFOVSAXKHENZIDOHUQRMXXUMFDDYGFEYPTZCOURHVEDKDOACAMYUOYEINZLVOCYDNXYKXPFKXWMDOCFZGCBWJJZRJZVSLTCPVUHZNZLVNZBDQYJXQWGBTLLQADGXJFZRTMMVBDKCZRKYLNZEJAIPLDLCTXVKLOFQNQFFKYDZGTFBFERGKEQMCVYLZQIIUOCWGDVICASICRUGGKBSRGYLDPIWKURUYIHBERGCGGXWUJDPROKXYKQQBUITESPOHBQNKQKUGWHLHKGABAPHQTFDBFHGVBLUYXWZOPSQEUKCLFKFWKXQWZAKBWBHILYFKYOIITLSHCNCYQDMJNFJEKJJDZQSWMJVNDTMYANVUCNZBDUAMHAPYNGGABONFABHVNQMKSNYHYYDLHKFHHDKHVSUSNWPPWDWVAYFKSMBSXUJUVLAIGWMQSNZYTVWBPLYYDSPRLUCGXOAAJLLVQIIHBCKZLPASFSNSUSYFHBMCBFOSTWISFNREQQYTKDCAHMKZTUAXOJIFTFVWWVMODLJMNBJEOIFEYNMAXZKTXXPEDAGSNZUVFRKIGJDCKUZOSKNADBFLGISKPPHYGXZMCMFAZJXAZHBQBQRREZXLNIOKHFKKPDRHTCRUEQXLXXDCVJLXISJXAWESPGXOXJYGEOQZEMXIKVPQRFQBXYARJWOJEKEXBQAEDYUIPLLDVKYKWPWMZHEIQGDNKSFYMIUINMORLIZMXMLHXSJOTKROYPHYKJHRBEXHAFVCJETIIMMPQKSPSPLOAYAPWBXUJWJBBIHVGVKDCFPABBAYMCZPIMZTOQBIDTJSDNKGUDECSFSRREZFBTUXIXJKIPXTNCFQUQDTANIWLEVDYODLIIWUVBOGQZWWPURCQVRYSJZDBSUCBXNLKFGCVWAGOIQIGSNVKWEMYBVXUAERMVJJLDZSPJKPVEOFJVPVGVOKSJYIFNLGBRUBYVNDYNHVLUDRYLJRGBKYSZBXNVDBYAHLZTQXUIBBOTBFKHSGYKPGCRWLMXZMHIOVKLIJTBUTFDIOJSCLMCJTTAFLMSYDWUNHEIKKSKJHXADKTUYNCEYAJDKVEIMKSQWLOGDYYDDKSRARLPGFZZNZUAJFRFEUNQJUAWJHFMARNJUIYEUZTDVRZHCEZVSFKHCDGTTNPFNKHSYPMXBOBNQYLLOAKFKNOYPEORITDIQRKMJIFOUEIBYCUXNQNUNBTNLNKCIOHEFUQCYFOBIIYBUWPRQRFOKONIRFILFQGJHFPLYASYJMZQPDWTSBKGQCYUVTBUNQNHNAEFGPJNVAGTPXFQRGMXTSVAJTRPBDBNZQACKJDTAMMEUASETGWFZWBYSFOMABHMXHLNQTBALMJFHXROGODUKWEYZMJFHKIIATYPLTUNTSXAJRCDZFJWFXRQWHPOSVXEDXOMRDMBQHAVOCMVTKGGPULOVCCKLEYCFGTYPCNCNHTWUWRMZJPBSCIMPXCZRPBIXQVAMEGSEYPGECDDFOFLQTASXNGKYWTAIRATEGYVZXTTVBFDDKWXOBEZXFNWPZXKJCDPNLVWOZNDNFEGUHYCDOOMTXBPIQLQWOTOIBBQZWXVGKMQWOWATZOZGBTRDKNDCPIVAILDYXKKNZYIYYTBFLWPAITVIRSPTZDHLFSIABOMDXQHTFNVLEUOUKTABUAWPRTURPUMHGKBUACFFFOXRIUGZAQSENYFNMGQJMSJVOBAEUQKGWPYVWPAFBNXIODTCEMCDQAXVLNYCQYVAXXYBHVDKHIUHPVUMQBFRYWTQKUVJJEAEXYCJZHRFCLDUGQRVIYLXUBXWGTCPTVELFADQXBCVTSEZNBBUAEUDGEJCVYTASTWCZYJQHGLYHZTGDDICBNLVYTJHMHENXSDHVLYFLHZQSOIDECOJQGXSQKHVFKPLDTOQYRGADZGIOOLYNWZXJRUIIYBWCNWAUPWGMUEQDFYVSVLBHQQXKCEEBMWQJYPIYGYZCDBZPKYRHROJQMQSBJILAMAKICREORUIJZRHWWFKBVZUAJRSCCDHBKUNZVWRHSIPHMBDAMNNQKHTFKYQRDRCEXZFTUAXFRPHOIPMZXCZJCUOQCZGPRMZIOTDISOSKROXJKLEAHTIRTMVEUCAYQVJBJCRNDJVXVVOUMPCGCZWUMAAPDEPSHNAIMATOLVNLMEPBJZWXMACWILFYKKKUYSUCCMFTJUOCCUPAGBYAKRUGNNSGRVBXDWGTQZZWHBKYJDKFNIEPBOLVIWSBEVYPMEKZMEVXOHKSLYLOSUSKCVEHBYRRUYKOHNENCVYODSTLPWDWOOONHNIYEGMYEKMTOPUWYKWCTHHDWZQXOCNQGZMTCTBPUILLKMAWSSJTRGXLSPQQYCZVKHHFCUGLIDEMBZUNQFSPCPHJQTUAYWQBJJSQYDFOJZOFIRJWOIOBXHFDIMSVISXEYYRKSQALVHUQLQOJZVDMADAIUKMJQGFAFJQOYWDFXPMBUOXOEISIHWBLFTQBSBCMQSKWMHNWOJRJOOAHBBKCVKSOGUCZQZVRPBMDKQYICBHJAZSCXKVRMBXHUGUZXFEJGUIANOFATRARRNZPYVBLJZTDZLRFIZBLVXKJRFACEVLDDQMRGZYUHJFBVPVLZJFNBKPKUFNAOEJEQNSNKITMIGJVIBPVIJTBEVSSVLCQZMSHQNDHZHXGGCTDZPOGABKKJTNIXVVGXHKRYILLFJMJHNKKDIQWGPPVJVCBWEQOVKIDJEBMKOLZGSLHMRHIQGLVWHICMTOXPITUPETITSOBUIWYRKMZMWFMSGFOORVZEBZPVBSCVETJKNHNQTJHNINAVAWQHPKHBCSAGDNLYAADUSPPTMGECGCBYDSMNGFPLHLMEQPDUYJVIRVRZFBRFMQKEWXOTZGTHMVBXBNUYACTBIRPPWWYMERCDUZTLKJJMXGBHFINZEEZPOFNCRTDYCEPYBZWNHKZXKNJNOTDVKFKXWKWOBTKAWEBEZAJMLPFUXOAQMEEAPDEWVJDVHMJIFZVPJKAZWPCVLRUWWXATRFIEKSQFVFIGJWYTMBMLLCQPQJNELFQLBCGLODVHXBWJNTQPKEMPRBWNAVCPJWKCIEKOOVBCMSLERUKVJCQAIXQBCHUXCDIQCSOTCHLQBYAXHWAJAFWZAQMHRTXMFDIWFFYQTVVSWXGIDAOHUHDQSYMOZESUHIEHBBCHTPTSBKBWVRSVNDQYSXMWNDBAECMHPOPMSAUCXOHITLWDNCPBVMKCUDAJESJBGMVXVTPBOOPAEGUGLKUJIIZPQPQVYPIBOOOBDOJUFCVEWMZMADYLIHDJJYALDZXDYNFCKNHQBIJHMAJWMYIYKCNGPRIVZMOUZRXRFVMZSDHAQJEOGJYEJIWHZSEHQVUBFNEFKFLTAFNFCDXNMJIXQNOPGMYVZUVWUFVKFXMYCBBQIUBWEVLYJHDSMZEDRJWVLPVCXJLPNACMEHOWHRJIEEXEAVAHUQYRYHEGRGDBHSGQAHFIIHVPSVXGQJRGOBNTLFILNFPMIDKEHUQBJHCKHBCWEWFAIILHINFVDOJBDLPGNPRTORKRMMCZNCYWFYDRTUYOTFRMZVPHRKKTERJKIJUWCVJANXEQWCUIXLWFUEGNPHHKELAKDLTQEEBMUUQHEJPOBTDLYRFBZGUOKCWARIBQJCUUBQLYRUMVCRGTEIYUDJIDIPZNNGMPNFIONDGFQGPEQPGEKNHEJMNTASLYRZUYKRIIERZLIDIHPEBYIBUDVYNXGVVKLOQPDVRNYLINDKNAEHTDIOLSUFZGOXGOFOFURIVLOCFBPGCYOCVBGFMKALQZNBKWNZPKIQWRLIMNKBBXJPQHCTUXAHUQTFBRBKDAFALDVVZRRPLOEVUCBUDBUUUFWFGBUWGKAKDRYCBVLOSSJZHSCYIXWOYBDUWSBFKSHSKVZLBNDNHNCZSKZNQIUUUYNVRDUPFJORXZDEVVRNGHYBKQEANYEYJDCQXPHEKNPAKRGZTODMNJKQZAICVLWCIWYDFSRDDBGVFKCOCZAZKDUBFTKLNYPTMRKJIOKPECEIBEABQGCKLJYMBIACXYPKNGHOKWBIPGLAXBVXKWCJCDGHCKWAZBRDFRNTZBZVCTXKTQNXTNGQWVAPWVLZXPXCSIOJWHWTZYXLZUSVTRYNJXQZBBVZXFBHJCDAWJAUJUUGLNTLCNIGZINJUAZHHOZCTXPCRNSMQBEEZWHIBSEAFALDETCFKCVLMQCCLZIVVZUMHGAEPAIFGSCINZQJEDNTSYGVTWSQWREKGFEUSLRZYXXTXABLAWYWMPYFXBIGRRITWTELCILVQRNWLJMNBSCILFZOUJGRGQWZDGXZWSVKVWQTMUKXZDCYDENZNEIMHXWYATJEMDEQTXYPMVFEKHSPZFXHYKPGWLSJCDOBYFGEUGOVJNXOTXKDHJTIFFTJWHHDXCNWOLPHGOHJORXKQUCTLSDMGSVRDUPWVZRUSEDIOMVFSYERIWIXVPSMHIISMNSWPVAQEIXIRJNABCAPOHKXTFXZANQJUSTEAOCTNXACBOTRLXHGLSXMHMATZXFLTFJDAIYSQSZEJUPSBRGFEGHBWIJAVFINBBCFQRPUTGARLCNJYHZIADZPSUBZPEYPEFLUGWPGIFNXTGBJCGRLVVBMDKLGNYPLZBXZQSSQYLZZTKJLNMXMSLBOCOXQPGDARJAFTDZCVJSPXXIZQIEHGYOBWULEYAZGISEMUWVNCIPBDJCLIWBCPKZKPUQFTITGLWJTLHALWOUYGHRGJWRCNNRSAELAKVVUXUGYMUKRJBYFKYENHZBDTQEBVLTGLCJSEJWJUZCYNCMRIUQNNCNIAGCTKLFEZDFWKHLPIWZCZGHYCJLJQWVKMDNBJNKIZWBWHQWPPJNREFYQMCDUGXMDDRUAYHZUNFGCKDDZSJAKIEYZCZRHEFNJXLISNBITZYWZEDQNQCPAXPTG"));

        System.out.println(commonChild("HARRY", "SALLY"));
        System.out.println(commonChild2("HARRY", "SALLY"));
    }
}
