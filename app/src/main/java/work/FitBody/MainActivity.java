package work.FitBody;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> movieArrayList;
    MovieAdapter adapter;

    //Создаем новый объект и вносим в него данные для приложения
    Movie[] movies = new Movie[] {
            new Movie("ПРИСЕДАНИЯ С ГАНТЕЛЯМИ",
                    "Каждый спортсмен или тренер согласится с тем, что приседания с гантелями – необходимое для набора мышечной массы упражнение. Без него вряд ли можно обойтись. Это базовое многосуставное движение, в котором прямо или косвенно принимает участие огромное количество мышечных групп. А без базы не будет роста. Хорошо подходит начинающих атлетов для разучивания техники приседаний. Также плюсом данного упражнения является отсутствие прямой нагрузки на позвоночник.",
                    "Ягодицы",
                    "Квадрицепс Бедра",
                    67025,
                    "https://pp.userapi.com/c855120/v855120691/9784/agY7dbVkEqQ.jpg",
                    "https://r2---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?ip=95.68.157.190&key=yt6&lmt=1541601390765386&dur=277.408&expire=1553193092&id=o-ALaSV0EOurTKR6xsIu4NsZ63KRFfSyX32mPfheREw802&source=youtube&initcwndbps=672500&fvip=2&mm=31%2C29&mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvw6&ratebypass=yes&requiressl=yes&mt=1553171399&mv=m&ei=I4STXKiDMcu07ATv95GQDg&ms=au%2Crdu&txp=5431432&itag=22&pl=17&mime=video%2Fmp4&c=WEB&pcm2cms=yes&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&ipbits=0&signature=C7E723CFB671960A29196E1291D8C6E2DDCB3D96.C94BB051E70484CE5BDD53840321A85300CFD0B2&title=%D0%9F%D1%80%D0%B8%D1%81%D0%B5%D0%B4%D0%B0%D0%BD%D0%B8%D1%8F%20%D1%81%20%D0%B3%D0%B0%D0%BD%D1%82%D0%B5%D0%BB%D1%8F%D0%BC%D0%B8_%20%D1%82%D0%B5%D1%85%D0%BD%D0%B8%D0%BA%D0%B0%20%D0%B8%20%D0%BD%D1%8E%D0%B0%D0%BD%D1%81%D1%8B",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "1. Исходное положение: возьмите гантели в руки, ладони внутрь. Станьте прямо, ноги на ширине плеч. При выполнении упражнения голову удерживать приподнятой, а спину прямой.\n" +
                            "2. На вдохе - медленно опускайтесь, сгибая колени, пока бедра не станут параллельны полу. Следите, чтобы колени не перекрывали носки ног – чтобы не перегружать коленный сустав.\n" +
                            "3. На выдохе – поднимайтесь в исходное положение, стараясь отталкиваться от пола пятками.\n" +
                            "4. Выполните необходимое количество повторений.",
                    "Гантели"),
            new Movie("РАЗВЕДЕНИЕ НОГ В ТРЕНАЖЕРЕ",
                    "Относится к одному из самых любимых упражнений девушек, которые только начинают заниматься в тренажерном зале. Отличается от сведения ног в тренажере тем, что нагружает внешнюю часть бедра.",
                    "Ягодицы",
                    "Бедра",
                    52366,
                    "https://psv4.userapi.com/c848028/u142324219/docs/d17/4b00f852eb85/s1200.jpg?extra=aJQ3ukJRJqMvbDXtp8IMSBs--4qciDKXIIfqzE0m94WcsC67KpaGrozdG8n1BEztSv3yOFBuaEdzgZIKBXTscXrDc8wqA2JShM367EscIqyTy7_G97j1EusPQWCjzwsvymLrXwtFzS0TCoa6xf3t9JSB",
                    "https://r1---sn-gvnuxaxjvh-0ate.googlevideo.com/videoplayback?key=yt6&source=youtube&pcm2cms=yes&mime=video%2Fmp4&fvip=5&ratebypass=yes&pl=19&signature=BEDC2732465ACC6338F279D94B1301FD00C85BC0.D07C5A22FB089CE2AA84A4415A78DCC7AAA257D4&itag=22&ei=vpCTXJaSCeTu7gTlmLFo&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&initcwndbps=655000&c=WEB&mn=sn-gvnuxaxjvh-0ate%2Csn-gvnuxaxjvh-bvws&mm=31%2C29&ipbits=0&id=o-APaxgDq2XeTwKf_V02VGFg3JNG79h152dvrXLUS93i7Y&dur=159.497&mv=m&mt=1553174605&ms=au%2Crdu&requiressl=yes&ip=92.252.235.74&lmt=1471021766023469&expire=1553196318&title=%D0%A0%D0%B0%D0%B7%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BD%D0%BE%D0%B3%20%D0%BD%D0%B0%20%D1%82%D1%80%D0%B5%D0%BD%D0%B0%D0%B6%D0%B5%D1%80%D0%B5",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Установить необходимый вес на тренажере.\n" +
                            "2. Садитесь на тренажер, ставьте ноги на подставки.\n" +
                            "3. Исходное положение – спина прямая, руками беритесь за рукоятки.\n" +
                            "4. На выдохе – разведите ноги.\n" +
                            "5. На вдохе – вернитесь в исходное положение.\n" +
                            "6. Сделайте разведение ног нужное количество раз.",
                    "Другие тренажеры"),
            new Movie("\"ЯГОДИЧНЫЙ МОСТ\" ОТ СКАМЬИ",
                    "Подъем ягодиц со штангой (ягодичный мостик) с опорой на скамью - хорошее упражнение, прорабатывающее ваши ягодичные мышцы. Возможны варианты где в качестве утяжеления используются блины от штанги. Всем девушкам, которые хотят иметь подтянутую попу – обязательно выполнять! Кроме ягодиц хорошо работают в этом упражнении бедра и икры. Подъем ягодиц подойдет и в начале тренировки для разминки и в конце - \"на добивание\". За счет того, что в упражнении используется скамья, таз мажет опускаться больше, за счет чего эффективность упражнения возрастает.",
                    "Ягодицы",
                    "Бедра",
                    263,
                    "https://pp.userapi.com/c850616/v850616691/e583f/WEwSzE9vUdY.jpg",
                    "https://r1---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&requiressl=yes&fvip=7&mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvws&source=youtube&txp=2211222&pl=19&id=o-AGjFDY1ek6Ww2Ozy3VYj8poUzTy1--46ZXZK75uRwazY&mv=m&mt=1553174946&ms=au%2Crdu&itag=22&mm=31%2C29&ip=92.252.235.74&ipbits=0&signature=CA0C48E88D4FBF2A81222838DBC37210044FBE3F.66F089C14124B69CB9598C01BBF4D233F1A1862E&initcwndbps=678750&pcm2cms=yes&key=yt6&mime=video%2Fmp4&c=WEB&expire=1553196648&ei=CJKTXOudLsPoyQWYioG4Dg&lmt=1540256063094387&dur=106.208&ratebypass=yes&title=%D0%AF%D0%B3%D0%BE%D0%B4%D0%B8%D1%87%D0%BD%D1%8B%D0%B9%20%D0%BC%D0%BE%D1%81%D1%82%D0%B8%D0%BA%20%D0%BD%D0%B0%20%D1%81%D0%BA%D0%B0%D0%BC%D1%8C%D0%B5.%20%D0%A2%D0%B5%D1%85%D0%BD%D0%B8%D0%BA%D0%B0%20%D0%B2%D1%8B%D0%BF%D0%BE%D0%BB%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F%20%D0%B8%20%D0%BF%D0%BE%D0%BB%D0%B5%D0%B7%D0%BD%D1%8B%D0%B5%20%D1%81%D0%BE%D0%B2%D0%B5%D1%82%D1%8B",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Исходное положение: сядьте перед скамьей, ноги расположите под нагруженной штангой. Лопатками упритесь в скамью.\n" +
                            "2. На выдохе - бедрами начните поднимать штангу вверх (руками можете придерживать гриф). Поднимайте таз как можно выше\n" +
                            "3. На вдохе – вернитесь в исходное положение.\n" +
                            "4. Выполните подъем ягодиц со штангой необходимое количество раз.",
                    "Штанга, Силовая скамья"),
            new Movie("ПОДЪЕМ НОГ В ВИСЕ",
                    "Подъем ног в висе на перекладине является одним из самых лучших упражнений для проработки мышц пресса. Подъем можно осуществлять как с согнутыми ногами, так и с прямыми.",
                    "Пресс",
                    "Нижняя часть спины",
                    41419,
                    "https://psv4.userapi.com/c848120/u142324219/docs/d4/78bfa718775e/2-89.jpg?extra=fU2IDcuZr8RYBTLII9xRE5PxV4a-S9onTZMAWwvpJub-cW1B7oA3PKN_L8vTOqnNrX6-drQ75cUFCpUVZ6ey-tb2WtqjtTA72qRVhoAgRBHjJoDnnMRHAnnFvagpBXJdEDDt_FYjD7WA0jww5bunFX4I",
                    "https://r1---sn-gvnuxaxjvh-0ate.googlevideo.com/videoplayback?dur=320.690&ms=au%2Crdu&mt=1553175010&mv=m&itag=22&signature=8F1F98F6CF8F19132CBF964245FAE504013F5A8A.03DF06F2B1F51F02F44B3F6CE0212D3F71CBCC12&mm=31%2C29&mn=sn-gvnuxaxjvh-0ate%2Csn-gvnuxaxjvh-bvw6&id=o-APqku7TNoXIafj3vDjXV3yCfQcYLMArMtl971mIzJp9E&expire=1553196751&pcm2cms=yes&ip=92.252.235.74&lmt=1540979115437919&ei=bpKTXJ28NoXuyQWauKeYCA&gcr=ru&pl=19&source=youtube&sparams=dur%2Cei%2Cgcr%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&initcwndbps=677500&c=WEB&mime=video%2Fmp4&ipbits=0&fvip=7&ratebypass=yes&requiressl=yes&txp=5531432&key=yt6&title=%D0%9F%D0%BE%D0%B4%D1%8A%D0%B5%D0%BC%D1%8B%20%D0%BD%D0%BE%D0%B3%20%D0%B2%20%D0%B2%D0%B8%D1%81%D0%B5%20%E2%80%93%20%D0%9A%D0%90%D0%9A%20%D0%9F%D0%A0%D0%90%D0%92%D0%98%D0%9B%D0%AC%D0%9D%D0%9E!",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Исходное положение: возьмитесь узким хватом и повисните на перекладине.\n" +
                            "2. На выдохе – сделайте подъем ног вверх, пока не коснетесь коленями груди.\n" +
                            "3. На вдохе – медленно опустите ноги в исходное положение.\n" +
                            "4. Сделайте подъем ног требуемое число повторов.",
                    "Другое"),
            new Movie("СКРУЧИВАНИЯ НА НАКЛОННОЙ СКАМЬЕ",
                    "Скручивания - основное упражнение для развития правильной и красивой формы мышц пресса. Скручивания можно выполнять как на полу, но сложнее это делать на наклонной скамье. Это упражнение прекрасно подойдет как разминка - для начала любой тренировки, так и для её окончания. Существует много вариантов этого упражнения, позволяющих регулировать нагрузку на разные части пресса.",
                    "Пресс",
                    "Нижняя часть спины",
                    151482,
                    "https://psv4.userapi.com/c848120/u142324219/docs/d7/17a8d8a02027/1782_1.jpg?extra=86JuA5lbj0EyYlTV3NV6tRDXdwbXut-ckZh1QWwMdGjp4_HTY3j2KvIDm1NYFPgc8EA9HtFZG9aAYSdphBfqZDU3pZ-TJs3a0zjRZIV4PBtDRp_rTRGwuECYfj3Tpx4oDNjd_yu94BTFHkl-j7QmnOI5",
                    "https://r1---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvw6&key=yt6&txp=5431432&pl=19&ipbits=0&initcwndbps=612500&fvip=5&requiressl=yes&ei=v5KTXKjmLYHV7QSArp-YBQ&itag=22&source=youtube&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&dur=460.358&id=o-AF9gIblU1c4fidJ235yfQRFnMdzVNIkOxbZU_6x-UQks&signature=951CF242E10BBA71FA8BF207A75D922AF28F1866.6967F450386A65FD7E36C073D2CB5C48266D6C7F&c=WEB&mime=video%2Fmp4&ms=au%2Crdu&mv=m&mt=1553175085&pcm2cms=yes&mm=31%2C29&ip=92.252.235.74&ratebypass=yes&expire=1553196831&lmt=1541136888530014&title=%D0%A1%D0%BA%D1%80%D1%83%D1%87%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F%20%D0%BD%D0%B0%20%D0%BD%D0%B0%D0%BA%D0%BB%D0%BE%D0%BD%D0%BD%D0%BE%D0%B9%20%D1%81%D0%BA%D0%B0%D0%BC%D1%8C%D0%B5_%205%20%D0%B2%D0%B0%D1%80%D0%B8%D0%B0%D0%BD%D1%82%D0%BE%D0%B2%20%D1%81%D0%BB%D0%BE%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D0%B8",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Займите положение на наклонной скамье – ноги согните в коленях, ступни зацепите за упоры.\n" +
                            "2. Исходное положение - лягте на спину, поясница прижата к скамье. Руки за головой (или перед грудью), кисти взяты в \"замочек\", локти разведены.\n" +
                            "3. На выдохе - усилием мышцы пресса переместите верхнюю часть туловища к коленям (туловище прижато или близко к коленям). Задержитесь на секунду.\n" +
                            "4. На вдохе –плавно вернитесь в исходное состояние.\n" +
                            "5. Повторить упражнение необходимое количество раз.",
                    "Силовая скамья"),
            new Movie("ПОДЪЁМ НА МЫСКИ СИДЯ",
                    "Одно из самых популярных упражнений для икроножной мышцы. Также тренирует камбаловидную мышцу. Выполняется на специальном тренажере. Но если его нет, то можно выполнять на скамье - со штангой, гантелями или используя машину Смитта.",
                    "Икры",
                    "Другое",
                    105670,
                    "https://psv4.userapi.com/c848336/u142324219/docs/d5/0786ecbc1aee/3-55.jpg?extra=Wvjihw15OEAPm7OMZPZD7phdkCJU2wSF4DUFS_jcgsZKJQq5y6-NoYOB5qql8VwHAulzMkiBq0prKLilWMD3WmeI8KKKaE_X9U2iTvnYT_FQEUKOA-FyTi_-P6Xah-uIpvgwk9mu02j5zZFpCTNob0nC",
                    "https://r1---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?expire=1553196890&itag=22&fvip=8&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&pcm2cms=yes&source=youtube&mime=video%2Fmp4&lmt=1471737457571963&ms=au%2Crdu&mv=m&mt=1553175161&dur=322.850&mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvw6&mm=31%2C29&ei=-pKTXOvDL8PuyAWD4JmgBQ&id=o-AOvYPd5wyiiDv2DXIfUjxJ5FpVaBVZY2pXYBO5Sl0DPd&ipbits=0&key=yt6&ip=92.252.235.74&requiressl=yes&signature=058C5C7BF8509E256260A98C86BCB65C4397975E.17A81DF8E4B8121454E94250F4EA2B97D2E7C7F9&pl=19&c=WEB&ratebypass=yes&initcwndbps=672500&title=%D0%AD%D1%82%D0%BE%20%D0%9F%D0%9E%D0%94%D0%AA%D0%95%D0%9C%20%D0%9D%D0%90%20%D0%9D%D0%9E%D0%A1%D0%9A%D0%98%20%D0%A1%D0%98%D0%94%D0%AF%2C%20%D0%B4%D0%B5%D1%82%D0%BA%D0%B0",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Расположите подставку (брусок или диск от штанги) на расстоянии около 30 см от скамьи.\n" +
                            "2. Исходное положение: сядьте на край скамьи, поставьте носки на подставку (ноги чуть уже ширины плеч). Возьмите штангу обратным хватом (или попросите кого-нибудь подать), положите её на бедра, примерно на 10 см выше коленей.\n" +
                            "3. На выдохе – поднимитесь на носках максимально высоко, задержитесь в верхней точке на 1-2 секунды.\n" +
                            "4. На вдохе - вернитесь в исходное положение.\n" +
                            "5. Сделайте необходимое количество повторений.",
                    "Гантели, Машина Смита, Другие тренажеры, Штанга"),
            new Movie("СГИБАНИЕ НОГ В ТРЕНАЖЕРЕ ЛЕЖА",
                    "Упражнение предназначено для проработки задней поверхности бедра, является изолирующим – позволяет качественно загрузить бедро без участия поясничных и ягодичных мышц.",
                    "Бедра",
                    "Икры",
                    156302,
                    "https://psv4.userapi.com/c848320/u142324219/docs/d7/fa14f5a5148d/s1200.jpg?extra=oZ5mG0w7eUYIsVwegd7g7o-fMzNzaPvt5nqzEMx94VVoSWzClp-ByX7qibjFfRMz3KiQfeFd1P_babYsyTfUfpRe_04MIP3UQvL1GM-Qyjdk9Su2ltK6OSTjtVJtnmx7Hf1DDXTsqdlnFjA0eMB1Uvvz",
                    "https://r2---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?key=yt6&ip=92.252.235.74&mt=1553175279&mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvwz&mm=31%2C29&signature=11A938CDEC717D2C7F3EC70C4184CFE95640B5C4.56CFD92C094841AF44E76E0D61E5EAFEDA9AFCF9&ms=au%2Crdu&ei=U5OTXOWLOIus7QTZ8piwAw&id=o-ACY_gQL8OZ_XYnYvoxBS67qI34ybir-a3xwVjdF1zCQZ&mv=m&fvip=5&dur=124.412&lmt=1471612021630595&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&source=youtube&pl=19&itag=22&requiressl=yes&mime=video%2Fmp4&ratebypass=yes&ipbits=0&pcm2cms=yes&expire=1553196980&c=WEB&initcwndbps=672500&title=%D0%A1%D0%B3%D0%B8%D0%B1%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BD%D0%BE%D0%B3%20%D0%BB%D0%B5%D0%B6%D0%B0%20%D0%9E%D1%88%D0%B8%D0%B1%D0%BA%D0%B8%20%D0%B8%20%D1%82%D0%B5%D1%85%D0%BD%D0%B8%D0%BA%D0%B0%20%D0%B2%D1%8B%D0%BF%D0%BE%D0%BB%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Лягте животом на тренажер для сгибания ног так чтобы колени немного выступали за край скамьи, а фиксаторы были на ахилловом сухожилии.\n" +
                            "2. Исходное положение - ноги зафиксируете под валиками, возьмитесь за рукоятки.\n" +
                            "3. На выдохе - сокращайте бицепс бедра (поднимайте ноги).\n" +
                            "4. На вдохе - плавно растягивайте (опускайте ноги).\n" +
                            "5. Повторите сгибание ног нужное количество раз.",
                    "Другие тренажеры"),
            new Movie("ПОДТЯГИВАНИЯ ОБРАТНЫМ ХВАТОМ",
                    "Подтягивания обратным хватом является отличным базовым упражнением для проработки бицепса и широчайших мышц спины. Выполнять данное упражнение необходимо с идеальной техникой, иначе нагрузка будет распределена между остальными мышечными группами, снижая эффективность упражнения.",
                    "Широчайшие мышцы спины",
                    "Бицепс Предплечья, Средняя часть спины",
                    120664,
                    "https://psv4.userapi.com/c848224/u142324219/docs/d3/24690ff1d863/kak-nauchitysya-podtyagivatysya-obratnym-hvatom-1024x778.jpg?extra=GLZferg7WcJU4n-xiLr_rRptIDPDhLzsFLUUkOSc_Oo27pYrJsY4Yu6wOc5x9FJy61m_3rVcIMgNSCWfSxOpnnORUqOynv13ZHPLJDmtwwy9KKI_anwy6S3mj4KzDoMZXQpQAQIihoVa7cbUqMYuGV6Q",
                    "https://r2---sn-gvnuxaxjvh-0ate.googlevideo.com/videoplayback?mime=video%2Fmp4&requiressl=yes&mn=sn-gvnuxaxjvh-0ate%2Csn-gvnuxaxjvh-bvwz&mm=31%2C29&key=yt6&mv=m&mt=1553175450&ms=au%2Crdu&source=youtube&ip=92.252.235.74&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&initcwndbps=685000&ei=DZSTXPGdG4Of7ASWwa3IDQ&id=o-ABHBu2yFV7Gl6gLRsh77iVDBKX7YlpH2jc0gFDIk_Smd&lmt=1471226948322563&fvip=4&pcm2cms=yes&ratebypass=yes&c=WEB&pl=19&expire=1553197165&dur=263.291&signature=7B42DC84259595833BF94967FAA41DF11611BC5E.C596EC6EE6D04A6FB9DAC6E7D380F860B03D2307&ipbits=0&itag=22&title=%D0%AD%D1%82%D0%BE%20%D0%9F%D0%9E%D0%94%D0%A2%D0%AF%D0%93%D0%98%D0%92%D0%90%D0%9D%D0%98%D0%AF%20%D0%9E%D0%91%D0%A0%D0%90%D0%A2%D0%9D%D0%AB%D0%9C%20%D0%A5%D0%92%D0%90%D0%A2%D0%9E%D0%9C%2C%20%D0%B4%D0%B5%D1%82%D0%BA%D0%B0!",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Исходное положение: Встаньте у турника и ухватитесь за турник обратным хватом немного уже ширины ваших плеч. Старайтесь держать тело как можно более прямым.\n" +
                            "2. На выдохе – удерживая локти максимально близко к туловищу, выполните подъем тела вверх, пока подбородок не достигнет уровня выше перекладины. Задержитесь в пиковой позиции для наиболее эффективной проработки бицепса.\n" +
                            "3. На вдохе – плавно опустите тело вниз, возвращаясь к исходному положению.\n" +
                            "4. Выполните необходимое количество повторений.",
                    "Другие тренажеры"),
            new Movie("ТЯГА ОДНОЙ ГАНТЕЛИ В НАКЛОНЕ",
                    "Довольно сложное упражнение, так как необходимо соблюдать много нюансов. Упражнение не подходит для новичков - сложно научиться выполнять его правильно. Для выполнения упражнения вам понадобится силовая скамья (или что-нибудь похожее на неё).",
                    "Средняя часть спины",
                    "Бицепс, Плечи, Широчайшие мышцы спины",
                    977639,
                    "https://psv4.userapi.com/c848332/u142324219/docs/d17/5c16ce291769/dumbbell-row-weights-bench-main.jpg?extra=PY86vBH8vH2vqbaY0S0mSgqjgVtKCIjmgK0EGuMCZhyrsJrrPx5X_f3V7QQHoTpWxxFs6ZymkPjkzto5mhdLOJA66m1RbALFE0Hf7-06N-hxgXeIXy-WJmEzyzt3o0W9Gzv1ElvqvxVn27XcSYaHa6MN",
                    "https://r2---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?itag=22&ipbits=0&lmt=1508913837064880&expire=1553197311&mime=video%2Fmp4&key=yt6&fvip=7&requiressl=yes&source=youtube&ratebypass=yes&pcm2cms=yes&dur=183.785&initcwndbps=660000&pl=19&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&ei=n5STXJr_G8WzyAXa75f4Bw&ip=92.252.235.74&id=o-AKcVtIrsnSNtYSH8qMOwojqX3Cj7n3n7fhTRoPE3-XTF&c=WEB&mm=31%2C29&mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvws&mt=1553175636&mv=m&signature=9B4DEDC3A2FC1B51DC5AC1D135449E9FCF0D8F5D.3E02B63D2B6C8672A5FAE84A3ACD338E3516B7EC&ms=au%2Crdu&title=%D0%A3%D0%BF%D1%80%D0%B0%D0%B6%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F%20%D0%B4%D0%BB%D1%8F%20%D1%81%D0%BF%D0%B8%D0%BD%D1%8B.%20%D0%A2%D1%8F%D0%B3%D0%B0%20%D0%B3%D0%B0%D0%BD%D1%82%D0%B5%D0%BB%D0%B8%20%D0%B2%20%D0%BD%D0%B0%D0%BA%D0%BB%D0%BE%D0%BD%D0%B5",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Исходное положение: правым коленом встаньте на скамью. Затем наклонитесь (чтобы туловище было почти параллельно полу) и упритесь в край скамьи правой рукой. Левой рукой поднимите гантель, ладонь обращена к туловищу. Спину держите прямо.\n" +
                            "2. На выдохе – тяните гантель к пояснице за счет сокращения мышц спины (руки не должны участвовать).Всё туловище остается неподвижным. Старайтесь поднимать локоть повыше и не отводите руку в сторону.\n" +
                            "3. На вдохе – медленно верните гантель в исходное положение.\n" +
                            "Повторите упражнение необходимое количество раз.\n" +
                            "4. Смените сторону, и повторите упражнение другой рукой.",
                    "Гантели"),
//            new Movie("",
//                    "",
//                    "",
//                    1,
//                    "",
//                    "",
//                    "",
//                    ""),
    };

    //Связываем данные
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setIcon(R.drawable.ic_action_logo);
            actionBar.setTitle("    " + actionBar.getTitle());
        }

        movieArrayList = new ArrayList<>(Arrays.asList(movies));
        adapter = new MovieAdapter(this, movieArrayList);

        ListView movieListView = (ListView) findViewById(R.id.movieListView);
        movieListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//        SearchView searchView = searchItem.getActionView() as SearchView;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("Поиск", newText);

                movieArrayList.clear();

                if (newText.equals("")) {
                    movieArrayList.addAll(Arrays.asList(movies));
                } else {
                    for (Movie movie : movies) {
                        if (movie.getName().toLowerCase().contains(newText.toLowerCase())) {
                            movieArrayList.add(movie);
                        }
                    }
                }

                adapter.notifyDataSetChanged();

                return false;
            }
        });
            return super.onCreateOptionsMenu(menu);
    }

}
