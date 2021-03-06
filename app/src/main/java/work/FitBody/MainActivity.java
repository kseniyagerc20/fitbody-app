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
//Основной класс с данными об упражнениях
public class MainActivity extends AppCompatActivity {

    ArrayList<Workout> workoutArrayList;
    FullInfoAdapter adapter;

    //Создаем новый объект и вносим в него данные для приложения
    Workout[] workouts = new Workout[] {
            new Workout("ПРИСЕДАНИЯ С ГАНТЕЛЯМИ",
                    "Каждый спортсмен или тренер согласится с тем, что приседания с гантелями – необходимое для набора мышечной массы упражнение. Без него вряд ли можно обойтись. Это базовое многосуставное движение, в котором прямо или косвенно принимает участие огромное количество мышечных групп. А без базы не будет роста. Хорошо подходит начинающих атлетов для разучивания техники приседаний. Также плюсом данного упражнения является отсутствие прямой нагрузки на позвоночник.",
                    "Ягодицы",
                    "Квадрицепс Бедра",
                    67025,
                    "https://pp.userapi.com/c855120/v855120691/9784/agY7dbVkEqQ.jpg",
                    "UIcvBlo5Iqg",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Исходное положение: возьмите гантели в руки, ладони внутрь. Станьте прямо, ноги на ширине плеч. При выполнении упражнения голову удерживать приподнятой, а спину прямой.\n" +
                            "2. На вдохе - медленно опускайтесь, сгибая колени, пока бедра не станут параллельны полу. Следите, чтобы колени не перекрывали носки ног – чтобы не перегружать коленный сустав.\n" +
                            "3. На выдохе – поднимайтесь в исходное положение, стараясь отталкиваться от пола пятками.\n" +
                            "4. Выполните необходимое количество повторений.",
                    "Гантели"),
            new Workout("РАЗВЕДЕНИЕ НОГ В ТРЕНАЖЕРЕ",
                    "Относится к одному из самых любимых упражнений девушек, которые только начинают заниматься в тренажерном зале. Отличается от сведения ног в тренажере тем, что нагружает внешнюю часть бедра.",
                    "Ягодицы",
                    "Бедра",
                    52366,
                    "https://www.domsporta.com/upload/iblock/954/58e449cc-6f14-11e0-a576-00e04cff6f38_4aecf34e-4bb3-11e1-93a8-00155d000a00.resize1.jpeg",
                    "dDUz97h35_M",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Установить необходимый вес на тренажере.\n" +
                            "2. Садитесь на тренажер, ставьте ноги на подставки.\n" +
                            "3. Исходное положение – спина прямая, руками беритесь за рукоятки.\n" +
                            "4. На выдохе – разведите ноги.\n" +
                            "5. На вдохе – вернитесь в исходное положение.\n" +
                            "6. Сделайте разведение ног нужное количество раз.",
                    "Другие тренажеры"),
            new Workout("\"ЯГОДИЧНЫЙ МОСТ\" ОТ СКАМЬИ",
                    "Подъем ягодиц со штангой (ягодичный мостик) с опорой на скамью - хорошее упражнение, прорабатывающее ваши ягодичные мышцы. Возможны варианты где в качестве утяжеления используются блины от штанги. Всем девушкам, которые хотят иметь подтянутую попу – обязательно выполнять! Кроме ягодиц хорошо работают в этом упражнении бедра и икры. Подъем ягодиц подойдет и в начале тренировки для разминки и в конце - \"на добивание\". За счет того, что в упражнении используется скамья, таз мажет опускаться больше, за счет чего эффективность упражнения возрастает.",
                    "Ягодицы",
                    "Бедра",
                    263,
                    "https://pp.userapi.com/c850616/v850616691/e583f/WEwSzE9vUdY.jpg",
                    "potpOOWw85A",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Исходное положение: сядьте перед скамьей, ноги расположите под нагруженной штангой. Лопатками упритесь в скамью.\n" +
                            "2. На выдохе - бедрами начните поднимать штангу вверх (руками можете придерживать гриф). Поднимайте таз как можно выше\n" +
                            "3. На вдохе – вернитесь в исходное положение.\n" +
                            "4. Выполните подъем ягодиц со штангой необходимое количество раз.",
                    "Штанга, Силовая скамья"),
            new Workout("ПОДЪЕМ НОГ В ВИСЕ",
                    "Подъем ног в висе на перекладине является одним из самых лучших упражнений для проработки мышц пресса. Подъем можно осуществлять как с согнутыми ногами, так и с прямыми.",
                    "Пресс",
                    "Нижняя часть спины",
                    41419,
                    "http://images-on-off.com/images/140/chemmozhnozamenitpodeminogvvisevzaleupra-66984e72.jpg",
                    "CNj1xF2ona0",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Исходное положение: возьмитесь узким хватом и повисните на перекладине.\n" +
                            "2. На выдохе – сделайте подъем ног вверх, пока не коснетесь коленями груди.\n" +
                            "3. На вдохе – медленно опустите ноги в исходное положение.\n" +
                            "4. Сделайте подъем ног требуемое число повторов.",
                    "Другое"),
            new Workout("СКРУЧИВАНИЯ НА НАКЛОННОЙ СКАМЬЕ",
                    "Скручивания - основное упражнение для развития правильной и красивой формы мышц пресса. Скручивания можно выполнять как на полу, но сложнее это делать на наклонной скамье. Это упражнение прекрасно подойдет как разминка - для начала любой тренировки, так и для её окончания. Существует много вариантов этого упражнения, позволяющих регулировать нагрузку на разные части пресса.",
                    "Пресс",
                    "Нижняя часть спины",
                    151482,
                    "https://www.fitforfun.de/files/images/201009/2/bauchmuskeltrainer_rechte-klaren,30183_m_n.jpg",
                    "CD78fMVLTuo",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Займите положение на наклонной скамье – ноги согните в коленях, ступни зацепите за упоры.\n" +
                            "2. Исходное положение - лягте на спину, поясница прижата к скамье. Руки за головой (или перед грудью), кисти взяты в \"замочек\", локти разведены.\n" +
                            "3. На выдохе - усилием мышцы пресса переместите верхнюю часть туловища к коленям (туловище прижато или близко к коленям). Задержитесь на секунду.\n" +
                            "4. На вдохе –плавно вернитесь в исходное состояние.\n" +
                            "5. Повторить упражнение необходимое количество раз.",
                    "Силовая скамья"),
            new Workout("ПОДЪЁМ НА МЫСКИ СИДЯ",
                    "Одно из самых популярных упражнений для икроножной мышцы. Также тренирует камбаловидную мышцу. Выполняется на специальном тренажере. Но если его нет, то можно выполнять на скамье - со штангой, гантелями или используя машину Смитта.",
                    "Икры",
                    "Другое",
                    105670,
                    "https://domsili.ru/image/cache/catalog/67619_html_ea17bf6-800x600.png",
                    "XitPbkHneD4",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Расположите подставку (брусок или диск от штанги) на расстоянии около 30 см от скамьи.\n" +
                            "2. Исходное положение: сядьте на край скамьи, поставьте носки на подставку (ноги чуть уже ширины плеч). Возьмите штангу обратным хватом (или попросите кого-нибудь подать), положите её на бедра, примерно на 10 см выше коленей.\n" +
                            "3. На выдохе – поднимитесь на носках максимально высоко, задержитесь в верхней точке на 1-2 секунды.\n" +
                            "4. На вдохе - вернитесь в исходное положение.\n" +
                            "5. Сделайте необходимое количество повторений.",
                    "Гантели, Машина Смита, Другие тренажеры, Штанга"),
            new Workout("СГИБАНИЕ НОГ В ТРЕНАЖЕРЕ ЛЕЖА",
                    "Упражнение предназначено для проработки задней поверхности бедра, является изолирующим – позволяет качественно загрузить бедро без участия поясничных и ягодичных мышц.",
                    "Бедра",
                    "Икры",
                    156302,
                    "https://www.buyandsellfitness.com/wp-content/uploads/2014/11/Life-Fitness-Pro-1-Lying-Leg-Curl.jpg",
                    "6Q84re6jMAs",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Лягте животом на тренажер для сгибания ног так чтобы колени немного выступали за край скамьи, а фиксаторы были на ахилловом сухожилии.\n" +
                            "2. Исходное положение - ноги зафиксируете под валиками, возьмитесь за рукоятки.\n" +
                            "3. На выдохе - сокращайте бицепс бедра (поднимайте ноги).\n" +
                            "4. На вдохе - плавно растягивайте (опускайте ноги).\n" +
                            "5. Повторите сгибание ног нужное количество раз.",
                    "Другие тренажеры"),
            new Workout("ПОДТЯГИВАНИЯ ОБРАТНЫМ ХВАТОМ",
                    "Подтягивания обратным хватом является отличным базовым упражнением для проработки бицепса и широчайших мышц спины. Выполнять данное упражнение необходимо с идеальной техникой, иначе нагрузка будет распределена между остальными мышечными группами, снижая эффективность упражнения.",
                    "Широчайшие мышцы спины",
                    "Бицепс Предплечья, Средняя часть спины",
                    120664,
                    "https://turnik.su/wp-content/uploads/2017/07/kak-nauchitysya-podtyagivatysya-obratnym-hvatom-1024x778.jpg",
                    "qY2k9p33J7U",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Исходное положение: Встаньте у турника и ухватитесь за турник обратным хватом немного уже ширины ваших плеч. Старайтесь держать тело как можно более прямым.\n" +
                            "2. На выдохе – удерживая локти максимально близко к туловищу, выполните подъем тела вверх, пока подбородок не достигнет уровня выше перекладины. Задержитесь в пиковой позиции для наиболее эффективной проработки бицепса.\n" +
                            "3. На вдохе – плавно опустите тело вниз, возвращаясь к исходному положению.\n" +
                            "4. Выполните необходимое количество повторений.",
                    "Другие тренажеры"),
            new Workout("ТЯГА ОДНОЙ ГАНТЕЛИ В НАКЛОНЕ",
                    "Довольно сложное упражнение, так как необходимо соблюдать много нюансов. Упражнение не подходит для новичков - сложно научиться выполнять его правильно. Для выполнения упражнения вам понадобится силовая скамья (или что-нибудь похожее на неё).",
                    "Средняя часть спины",
                    "Бицепс, Плечи, Широчайшие мышцы спины",
                    977639,
                    "https://lovefit.ru/imgs/blog/034/34/blg5bd989b0c3b516_13974808.jpg",
                    "Ch4UZW_j08Q",
                    "ТЕХНИКА ВЫПОЛНЕНИЯ:\n" +
                            "\n" +
                            "1. Исходное положение: правым коленом встаньте на скамью. Затем наклонитесь (чтобы туловище было почти параллельно полу) и упритесь в край скамьи правой рукой. Левой рукой поднимите гантель, ладонь обращена к туловищу. Спину держите прямо.\n" +
                            "2. На выдохе – тяните гантель к пояснице за счет сокращения мышц спины (руки не должны участвовать).Всё туловище остается неподвижным. Старайтесь поднимать локоть повыше и не отводите руку в сторону.\n" +
                            "3. На вдохе – медленно верните гантель в исходное положение.\n" +
                            "Повторите упражнение необходимое количество раз.\n" +
                            "4. Смените сторону, и повторите упражнение другой рукой.",
                    "Гантели"),
//            new Workout("",
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

        workoutArrayList = new ArrayList<>(Arrays.asList(workouts));
        adapter = new FullInfoAdapter(this, workoutArrayList);

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

                workoutArrayList.clear();

                if (newText.equals("")) {
                    workoutArrayList.addAll(Arrays.asList(workouts));
                } else {
                    for (Workout workout : workouts) {
                        if (workout.getName().toLowerCase().contains(newText.toLowerCase())) {
                            workoutArrayList.add(workout);
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
