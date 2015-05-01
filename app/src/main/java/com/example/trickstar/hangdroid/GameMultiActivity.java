package com.example.trickstar.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class GameMultiActivity extends ActionBarActivity {

    String mWord;

    int mFailCounter = 0;

    int mGuessedLetters = 0;

    int mPoints = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_game);

        String wordSend = getIntent().getStringExtra("WORD_IDENTIFIER");

        Log.d("MYLOG",wordSend);

        setRandomWord();
    }


    /**
     * Retrieving the letter introduced on the editText
     *
     * @param v (Button clicked)
     */
    public void introduceLetter(View v) {

        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);

        String letter = myEditText.getText().toString();

        myEditText.setText("");

        Log.d("MYLOG", "The letter introduced is " + letter);

        if (letter.length() == 1) {
            checkLetter(letter.toUpperCase());
        } else {
            Toast.makeText(this,"Please introduce letter",Toast.LENGTH_SHORT).show();
        }

    }



    public void checkLetter(String introducedLetter) {

        char charIntroduced = introducedLetter.charAt(0);

        boolean letterGuessed = false;

        for ( int i =0 ; i < mWord.length() ; i++) {

            char charFromTheWord = mWord.charAt(i);

            if (mWord.charAt(i) == introducedLetter.charAt(0)) {

                Log.d("MYLOG","There was one match");

                letterGuessed = true;

                showLetterAtIndex(i, charIntroduced);

                mGuessedLetters++;

            }
        }

        if (letterGuessed == false) {
            letterFailed(Character.toString(charIntroduced));
        }

        if (mGuessedLetters == mWord.length()) {
            mPoints++;
            clearScreen();
            setRandomWord();

        }
    }



    public void setRandomWord() {

        String words = "AAHS AALS ABAC ABAS ABBA ABBE ABBS ABED ABET ABID ABLE ABLY ABOS ABRI ABUT ABYE ABYS ACAI ACCA ACED ACER ACES ACHE ACHY ACID ACME ACNE ACRE ACTA ACTS ACYL ADAW ADDS ADDY ADIT ADOS ADRY ADZE AEON AERO AERY AESC AFAR AFFY AFRO AGAR AGAS AGED AGEE AGEN AGER AGES AGHA AGIN AGIO AGLU AGLY AGMA AGOG AGON AGUE AHED AHEM AHIS AHOY AIAS AIDE AIDS AIGA AILS AIMS AINE AINS AIRN AIRS AIRT AIRY AITS AITU AJAR AJEE AKED AKEE AKES AKIN ALAE ALAN ALAP ALAR ALAS ALAY ALBA ALBE ALBS ALCO ALEC ALEE ALEF ALES ALEW ALFA ALFS ALGA ALIF ALIT ALKO ALKY ALLS ALLY ALMA ALME ALMS ALOD ALOE ALOW ALPS ALSO ALTO ALTS ALUM AMAH AMAS AMBO AMEN AMIA AMID AMIE AMIN AMIR AMIS AMLA AMMO AMOK AMPS AMUS AMYL ANAL ANAN ANAS ANCE ANDS ANES ANEW ANGA ANIL ANIS ANKH ANNA ANNO ANNS ANOA ANON ANOW ANSA ANTA ANTE ANTI ANTS ANUS APAY APED APER APES APEX APOD APOS APPS APSE APSO APTS AQUA ARAK ARAR ARBA ARBS ARCH ARCO ARCS ARDS AREA ARED AREG ARES ARET AREW ARFS ARIA ARID ARIL ARIS ARKS ARLE ARMS ARMY ARNA AROW ARPA ARSE ARSY ARTI ARTS ARTY ARUM ARVO ARYL ASAR ASCI ASEA ASHY ASKS ASPS ATAP ATES ATMA ATOC ATOK ATOM ATOP ATUA AUFS AUKS AULA AULD AUNE AUNT AURA AUTO AVAL AVAS AVEL AVER AVES AVID AVOS AVOW AWAY AWDL AWED AWEE AWES AWLS AWNS AWNY AWOL AWRY AXAL AXED AXEL AXES AXIL AXIS AXLE AXON AYAH AYES AYIN AYRE AYUS AZAN AZON AZYM BAAL BAAS BABA BABE BABU BABY BACH BACK BACS BADE BADS BAEL BAFF BAFT BAGH BAGS BAHT BAIL BAIT BAJU BAKE BALD BALE BALK BALL BALM BALS BALU BAMS BANC BAND BANE BANG BANI BANK BANS BANT BAPS BAPU BARB BARD BARE BARF BARK BARM BARN BARP BARS BASE BASH BASK BASS BAST BATE BATH BATS BATT BAUD BAUK BAUR BAWD BAWL BAWN BAWR BAYE BAYS BAYT BEAD BEAK BEAM BEAN BEAR BEAT BEAU BEMA BETA BHAT BIAS BIGA BIMA BLAB BLAD BLAE BLAG BLAH BLAM BLAT BLAW BLAY BOAB BOAK BOAR BOAS BOAT BOBA BOLA BOMA BONA BORA BOTA BRAD BRAE BRAG BRAK BRAN BRAS BRAT BRAW BRAY BUAT BUBA BUDA BUNA BURA CAAS CABA CABS CACA CADE CADI CADS CAFE CAFF CAGE CAGS CAGY CAID CAIN CAKE CAKY CALF CALK CALL CALM CALO CALP CALX CAMA CAME CAMO CAMP CAMS CANE CANG CANN CANS CANT CANY CAPA CAPE CAPH CAPI CAPO CAPS CARB CARD CARE CARK CARL CARN CARP CARR CARS CART CASA CASE CASH CASK CAST CATE CATS CAUF CAUK CAUL CAUM CAUP CAVA CAVE CAVY CAWK CAWS CAYS CEAS CECA CHAD CHAI CHAL CHAM CHAO CHAP CHAR CHAS CHAT CHAV CHAW CHAY CHIA CIAO CLAD CLAG CLAM CLAN CLAP CLAT CLAW CLAY COAL COAT COAX COCA CODA COLA COMA COXA CRAB CRAG CRAM CRAN CRAP CRAW CRAY CYAN CYMA CZAR DABS DACE DACK DADA DADO DADS DAES DAFF DAFT DAGO DAGS DAHL DAHS DAIS DAKS DALE DALI DALS DALT DAME DAMN DAMP DAMS DANG DANK DANS DANT DAPS DARB DARE DARG DARI DARK DARN DART DASH DATA DATE DATO DAUB DAUD DAUR DAUT DAVY DAWD DAWK DAWN DAWS DAWT DAYS DAZE DEAD DEAF DEAL DEAN DEAR DEAW DEVA DHAK DHAL DIAL DIKA DISA DITA DIVA DOAB DOAT DONA DOPA DRAB DRAC DRAD DRAG DRAM DRAP DRAT DRAW DRAY DUAD DUAL DUAN DUAR DUKA DUMA DURA DWAM DYAD EACH EALE EANS EARD EARL EARN EARS EASE EAST EASY EATH EATS EAUS EAUX EAVE ECAD EGAD EGAL EGMA EINA EKKA ELAN EMMA EOAN EPHA ERAS ETAS ETAT ETNA EXAM EYAS EYRA FAAN FAAS FABS FACE FACT FADE FADO FADS FADY FAFF FAGS FAHS FAIK FAIL FAIN FAIR FAIX FAKE FALL FALX FAME FAND FANE FANG FANK FANO FANS FARD FARE FARL FARM FARO FARS FART FASH FAST FATE FATS FAUN FAUR FAUT FAUX FAVA FAVE FAWN FAWS FAYS FAZE FEAL FEAR FEAT FETA FIAR FIAT FILA FLAB FLAG FLAK FLAM FLAN FLAP FLAT FLAW FLAX FLAY FLEA FOAL FOAM FORA FRAB FRAE FRAG FRAP FRAS FRAT FRAU FRAY GABS GABY GADE GADI GADS GAED GAEN GAES GAFF GAGA GAGE GAGS GAID GAIN GAIR GAIT GAJO GALA GALE GALL GALS GAMA GAMB GAME GAMP GAMS GAMY GANE GANG GANS GANT GAOL GAPE GAPO GAPS GAPY GARB GARE GARI GARS GART GASH GASP GAST GATE GATH GATS GAUD GAUM GAUN GAUP GAUR GAUS GAVE GAWD GAWK GAWP GAYS GAZE GAZY GEAL GEAN GEAR GEAT GENA GETA GHAT GIGA GILA GLAD GLAM GLIA GNAR GNAT GNAW GOAD GOAF GOAL GOAS GOAT GORA GRAB GRAD GRAM GRAN GRAT GRAV GRAY GUAN GUAR GUGA GULA GYAL HAAF HAAR HABU HACK HADE HADJ HADS HAED HAEM HAEN HAES HAET HAFF HAFT HAGG HAGS HAHA HAHS HAIK HAIL HAIN HAIR HAJI HAJJ HAKA HAKE HAKU HALE HALF HALL HALM HALO HALT HAME HAMS HAND HANG HANK HANT HAPS HAPU HARD HARE HARK HARL HARM HARN HARO HARP HART HASH HASK HASP HAST HATE HATH HATS HAUD HAUF HAUL HAUT HAVE HAWK HAWM HAWS HAYS HAZE HAZY HEAD HEAL HEAP HEAR HEAT HILA HIYA HOAR HOAS HOAX HOHA HOKA HOMA HORA HOYA HUIA HULA HUMA HWAN HYLA IAMB IDEA IGAD IKAN IKAT ILEA ILIA ILKA IMAM INIA IOTA ISBA ISNA ITAS IXIA IZAR JAAP JABS JACK JADE JAFA JAGA JAGG JAGS JAIL JAKE JAKS JAMB JAMS JANE JANN JAPE JAPS JARK JARL JARP JARS JASP JASS JASY JATO JAUK JAUP JAVA JAWS JAXY JAYS JAZY JAZZ JEAN JEAT JIAO JOTA JUBA JUGA JURA KAAL KAAS KABS KADE KADI KAED KAES KAFS KAGO KAGU KAID KAIE KAIF KAIK KAIL KAIM KAIN KAIS KAKA KAKI KAKS KALE KALI KAMA KAME KAMI KANA KANE KANG KANS KANT KAON KAPA KAPH KARA KARK KARN KARO KART KATA KATI KATS KAVA KAWA KAWS KAYO KAYS KAZI KBAR KEAS KETA KHAF KHAN KHAT KINA KIVA KLAP KNAG KNAP KNAR KOAN KOAP KOAS KOHA KOLA KORA KRAB KSAR KUIA KULA KUNA KUTA KVAS KYAK KYAR KYAT LABS LACE LACK LACS LACY LADE";

        String[] arrayWords = words.split(" ");

        Log.d("MYLOG","The array lenght "+arrayWords.length);

        int randomNummer = (int) ( Math.random() * arrayWords.length);

        String randomWord = arrayWords[randomNummer];

        mWord = randomWord;
    }



    public void clearScreen() {
        TextView textViewFailed = (TextView) findViewById(R.id.textView8);
        textViewFailed.setText("");

        mGuessedLetters = 0;
        mFailCounter = 0;

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);

        for (int i=0; i < layoutLetters.getChildCount() ; i++) {

            TextView currentTextView = (TextView) layoutLetters.getChildAt(i);
            currentTextView.setText("_");

        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.hangdroid_0);
    }



    public void letterFailed(String letterFailed){

        TextView textViewFailed = (TextView) findViewById(R.id.textView8);

        String previousFail = textViewFailed.getText().toString();

        textViewFailed.setText(previousFail+letterFailed);

        mFailCounter++;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        if (mFailCounter == 1) {
            imageView.setImageResource(R.drawable.hangdroid_1);
        } else if (mFailCounter == 2) {
            imageView.setImageResource(R.drawable.hangdroid_2);
        } else if (mFailCounter == 3) {
            imageView.setImageResource(R.drawable.hangdroid_3);
        } else if (mFailCounter == 4) {
            imageView.setImageResource(R.drawable.hangdroid_4);
        } else if (mFailCounter == 5) {
            imageView.setImageResource(R.drawable.hangdroid_5);
        } else if (mFailCounter == 6) {

            Intent gameOverIntent = new Intent(this,GameOverActivity.class);

            gameOverIntent.putExtra("POINTS_INDENTIFIER", mPoints);

            startActivity(gameOverIntent);

        }

    }

    public void showLetterAtIndex(int position, char letterGuessed) {

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);

        TextView textView = (TextView) layoutLetter.getChildAt(position);

        textView.setText(Character.toString(letterGuessed));
    }
}
