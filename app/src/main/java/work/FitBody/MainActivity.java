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
                    "https://r2---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?ip=95.68.129.213&requiressl=yes&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&mt=1553269527&txp=5431432&key=yt6&lmt=1541601390765386&c=WEB&ei=mQOVXPfDOobDyQXn07P4AQ&expire=1553291258&pcm2cms=yes&ipbits=0&mm=31%2C29&mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvw6&itag=22&fvip=2&dur=277.408&id=o-AIRYy6-UQlKgkaNZpcTzTrNyYtPOcC0aoGuusaRnei2W&initcwndbps=643750&pl=17&source=youtube&mv=m&mime=video%2Fmp4&signature=51A825A75748CF4F2AE06BC446A88AE2D6CF1447.E1671C6FF07634862170EBCE704460E0C5A146F0&ms=au%2Crdu&ratebypass=yes&title=%D0%9F%D1%80%D0%B8%D1%81%D0%B5%D0%B4%D0%B0%D0%BD%D0%B8%D1%8F%20%D1%81%20%D0%B3%D0%B0%D0%BD%D1%82%D0%B5%D0%BB%D1%8F%D0%BC%D0%B8_%20%D1%82%D0%B5%D1%85%D0%BD%D0%B8%D0%BA%D0%B0%20%D0%B8%20%D0%BD%D1%8E%D0%B0%D0%BD%D1%81%D1%8B",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
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
                    "https://www.domsporta.com/upload/iblock/954/58e449cc-6f14-11e0-a576-00e04cff6f38_4aecf34e-4bb3-11e1-93a8-00155d000a00.resize1.jpeg",
                    "https://r1---sn-gvnuxaxjvh-0ate.googlevideo.com/videoplayback?itag=22&ipbits=0&mm=31%2C29&mn=sn-gvnuxaxjvh-0ate%2Csn-gvnuxaxjvh-bvws&source=youtube&mv=m&mime=video%2Fmp4&signature=80105B23EDCFA8E7FEB05F2E3573898331BC986E.A4BFC80515923587AFF19754420FF7E9D78F8ED4&ms=au%2Crdu&fvip=5&dur=159.497&id=o-AKWwXhMAuWIBZcR8visWUGRaGr7kmr0Xg5MTdH0no0uu&initcwndbps=651250&pl=17&c=WEB&ei=6QOVXM3sDsO0yAXWroT4Aw&lmt=1471021766023469&ip=95.68.129.213&expire=1553291337&pcm2cms=yes&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&requiressl=yes&key=yt6&mt=1553269615&ratebypass=yes&title=%D0%A0%D0%B0%D0%B7%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BD%D0%BE%D0%B3%20%D0%BD%D0%B0%20%D1%82%D1%80%D0%B5%D0%BD%D0%B0%D0%B6%D0%B5%D1%80%D0%B5",
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
                    "https://r1---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?requiressl=yes&mm=31%2C29&mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvws&ipbits=0&mt=1553269615&mv=m&ei=FwSVXMPRHMTuyAXa7LHgDw&ms=au%2Crdu&expire=1553291383&initcwndbps=616250&source=youtube&pl=17&ratebypass=yes&c=WEB&mime=video%2Fmp4&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&fvip=7&pcm2cms=yes&ip=95.68.129.213&key=yt6&txp=2211222&lmt=1540256063094387&dur=106.208&signature=CF163604B1EC31E65154B4A8D627C43790E304A1.8D21AA6F374FA084008F698284E3D4AB451A03B2&itag=22&id=o-AIv1V25TZYgMKyTKcfinoS1LTOt_EAK4XMMWBOg3bkNL&title=%D0%AF%D0%B3%D0%BE%D0%B4%D0%B8%D1%87%D0%BD%D1%8B%D0%B9%20%D0%BC%D0%BE%D1%81%D1%82%D0%B8%D0%BA%20%D0%BD%D0%B0%20%D1%81%D0%BA%D0%B0%D0%BC%D1%8C%D0%B5.%20%D0%A2%D0%B5%D1%85%D0%BD%D0%B8%D0%BA%D0%B0%20%D0%B2%D1%8B%D0%BF%D0%BE%D0%BB%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F%20%D0%B8%20%D0%BF%D0%BE%D0%BB%D0%B5%D0%B7%D0%BD%D1%8B%D0%B5%20%D1%81%D0%BE%D0%B2%D0%B5%D1%82%D1%8B",
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
                    "http://images-on-off.com/images/140/chemmozhnozamenitpodeminogvvisevzaleupra-66984e72.jpg",
                    "https://r1---sn-gvnuxaxjvh-0ate.googlevideo.com/videoplayback?id=o-AOHuoO5Ed4MhcbAzh8R9UJ0eiBJrQ9hWZ4nDqOi4SZTA&requiressl=yes&dur=320.690&mm=31%2C29&mn=sn-gvnuxaxjvh-0ate%2Csn-gvnuxaxjvh-bvw6&pl=17&ms=au%2Crdu&mt=1553269731&mv=m&ip=95.68.129.213&ei=hQSVXPTgIcfFyAXdyb3QAg&c=WEB&source=youtube&ratebypass=yes&fvip=7&txp=5531432&pcm2cms=yes&itag=22&mime=video%2Fmp4&signature=91757ED449ECE8F883647D3FCAEAD4AFBFE9AD1B.D7901E1FAAE34413C76375540BD3FED0CD6EA75D&key=yt6&initcwndbps=651250&lmt=1540979115437919&gcr=ru&ipbits=0&expire=1553291493&sparams=dur%2Cei%2Cgcr%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&title=%D0%9F%D0%BE%D0%B4%D1%8A%D0%B5%D0%BC%D1%8B%20%D0%BD%D0%BE%D0%B3%20%D0%B2%20%D0%B2%D0%B8%D1%81%D0%B5%20%E2%80%93%20%D0%9A%D0%90%D0%9A%20%D0%9F%D0%A0%D0%90%D0%92%D0%98%D0%9B%D0%AC%D0%9D%D0%9E!",
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
                    "https://www.fitforfun.de/files/images/201009/2/bauchmuskeltrainer_rechte-klaren,30183_m_n.jpg",
                    "https://r1---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?fvip=5&ratebypass=yes&source=youtube&signature=8FA6B874A212C8FDD8F65E055B8110491396BBEC.51EAC2DBAB452DF7C6CA566B08D8C202707CB012&key=yt6&ei=jQSVXNSeOMfE7gSXmIj4CA&expire=1553291502&txp=5431432&initcwndbps=616250&id=o-ADXf2eM8mxaoZHjIW_5aQPuGfTaV1apLzBae5NbS3B72&dur=460.358&mime=video%2Fmp4&requiressl=yes&ms=au%2Crdu&mt=1553269731&itag=22&pl=17&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&ip=95.68.129.213&mv=m&mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvw6&lmt=1541136888530014&c=WEB&pcm2cms=yes&ipbits=0&mm=31%2C29&title=%D0%A1%D0%BA%D1%80%D1%83%D1%87%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F%20%D0%BD%D0%B0%20%D0%BD%D0%B0%D0%BA%D0%BB%D0%BE%D0%BD%D0%BD%D0%BE%D0%B9%20%D1%81%D0%BA%D0%B0%D0%BC%D1%8C%D0%B5_%205%20%D0%B2%D0%B0%D1%80%D0%B8%D0%B0%D0%BD%D1%82%D0%BE%D0%B2%20%D1%81%D0%BB%D0%BE%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D0%B8",
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
                    "https://domsili.ru/image/cache/catalog/67619_html_ea17bf6-800x600.png",
                    "https://r1---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?ms=au%2Crdu&pcm2cms=yes&mv=m&mt=1553269913&id=o-AHNq920KGZtzBLZkN23C5c3esjJmY12M-vl1hnVGEnsM&signature=7707D10E780F534AC6190057F76B7C82DD15C461.A72CC69AA1CF5B891FF1F156A5B233A02EB22C43&itag=22&pl=17&expire=1553291602&mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvw6&mm=31%2C29&ip=95.68.129.213&ei=8gSVXOPlCNWAyAXehp-wCA&initcwndbps=603750&source=youtube&requiressl=yes&ipbits=0&lmt=1471737457571963&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&fvip=8&ratebypass=yes&dur=322.850&c=WEB&mime=video%2Fmp4&key=yt6&title=%D0%AD%D1%82%D0%BE%20%D0%9F%D0%9E%D0%94%D0%AA%D0%95%D0%9C%20%D0%9D%D0%90%20%D0%9D%D0%9E%D0%A1%D0%9A%D0%98%20%D0%A1%D0%98%D0%94%D0%AF%2C%20%D0%B4%D0%B5%D1%82%D0%BA%D0%B0",
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
                    "https://www.buyandsellfitness.com/wp-content/uploads/2014/11/Life-Fitness-Pro-1-Lying-Leg-Curl.jpg",
                    "https://r2---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?id=o-ACt5qLyspf8SpfvqzijqpOtu36mpDZIhmhWYUxOqSDtr&dur=124.412&source=youtube&pcm2cms=yes&ip=95.68.129.213&requiressl=yes&fvip=5&itag=22&lmt=1471612021630595&ei=JgWVXNaXLcmCyAWKqbr4Ag&ms=au%2Crdu&mt=1553269913&mv=m&pl=17&signature=2C264FAF2C0E06D55C8180EAFD34116DC15298E0.94496A0065C0ED554266DFD7CB830247C9920A41&key=yt6&mm=31%2C29&mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvwz&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&c=WEB&ipbits=0&ratebypass=yes&initcwndbps=603750&expire=1553291654&mime=video%2Fmp4&title=%D0%A1%D0%B3%D0%B8%D0%B1%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BD%D0%BE%D0%B3%20%D0%BB%D0%B5%D0%B6%D0%B0%20%D0%9E%D1%88%D0%B8%D0%B1%D0%BA%D0%B8%20%D0%B8%20%D1%82%D0%B5%D1%85%D0%BD%D0%B8%D0%BA%D0%B0%20%D0%B2%D1%8B%D0%BF%D0%BE%D0%BB%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F",
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
                    "https://turnik.su/wp-content/uploads/2017/07/kak-nauchitysya-podtyagivatysya-obratnym-hvatom-1024x778.jpg",
                    "https://r2---sn-gvnuxaxjvh-0atl.googlevideo.com/videoplayback?mm=31%2C29&mn=sn-gvnuxaxjvh-0atl%2Csn-gvnuxaxjvh-bvws&ms=au%2Crdu&id=o-AKsMvkE5YavXQSw7-XlW01LO2WtChtyUeudPQf9Rl806&pl=17&mt=1553269913&mv=m&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&pcm2cms=yes&ip=95.68.129.213&requiressl=yes&c=WEB&ei=LwWVXPbYCfHV7gSg9LD4Dw&source=youtube&signature=8736E27C7B56DAC59CE3CD48754778007203BD46.312A1D653B0D3E0D18A306C9C1BF75514F719146&initcwndbps=603750&itag=22&mime=video%2Fmp4&key=yt6&ratebypass=yes&expire=1553291663&ipbits=0&fvip=7&dur=183.785&lmt=1508913837064880&title=%D0%A3%D0%BF%D1%80%D0%B0%D0%B6%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F%20%D0%B4%D0%BB%D1%8F%20%D1%81%D0%BF%D0%B8%D0%BD%D1%8B.%20%D0%A2%D1%8F%D0%B3%D0%B0%20%D0%B3%D0%B0%D0%BD%D1%82%D0%B5%D0%BB%D0%B8%20%D0%B2%20%D0%BD%D0%B0%D0%BA%D0%BB%D0%BE%D0%BD%D0%B5",
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
                    "https://lovefit.ru/imgs/blog/034/34/blg5bd989b0c3b516_13974808.jpg",
                    "https://r2---sn-gvnuxaxjvh-0ate.googlevideo.com/videoplayback?fvip=4&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&requiressl=yes&source=youtube&mt=1553270034&mv=m&ms=au%2Crdu&pl=17&id=o-AI5Bift9zPt6AXGNQDN9toFsLAjOAGcWP5avrzq4dNaw&ipbits=0&mm=31%2C29&ip=95.68.129.213&itag=22&initcwndbps=661250&pcm2cms=yes&signature=15CC3507F9005044089DE4200FEC9182682A53F6.79C2B0550841586CC1E6548B0A773610921C0FDC&c=WEB&expire=1553291670&ei=NgWVXPXhLJWA0u8PhtOZmAQ&mime=video%2Fmp4&key=yt6&mn=sn-gvnuxaxjvh-0ate%2Csn-gvnuxaxjvh-bvwz&lmt=1471226948322563&dur=263.291&ratebypass=yes&title=%D0%AD%D1%82%D0%BE%20%D0%9F%D0%9E%D0%94%D0%A2%D0%AF%D0%93%D0%98%D0%92%D0%90%D0%9D%D0%98%D0%AF%20%D0%9E%D0%91%D0%A0%D0%90%D0%A2%D0%9D%D0%AB%D0%9C%20%D0%A5%D0%92%D0%90%D0%A2%D0%9E%D0%9C%2C%20%D0%B4%D0%B5%D1%82%D0%BA%D0%B0!",
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
