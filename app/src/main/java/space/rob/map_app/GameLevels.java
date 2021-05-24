package space.rob.map_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.richpath.RichPath;
import com.richpath.RichPathView;
import com.richpathanimator.RichPathAnimator;

import java.util.Arrays;

public class GameLevels extends Activity {
    boolean canClick = true;

    String[] regionNumbers = {"Region_1", "Region_2", "Region_3", "Region_4",
            "Region_5", "Region_6", "Region_7", "Region_8", "Region_9",
            "Region_10", "Region_11", "Region_12", "Region_13", "Region_14",
            "Region_15", "Region_16", "Region_17", "Region_18", "Region_19",
            "Region_20", "Region_21", "Region_22", "Region_23", "Region_24",
            "Region_25", "Region_26", "Region_27", "Region_28", "Region_29",
            "Region_30", "Region_31", "Region_32", "Region_32", "Region_33",
            "Region_34", "Region_35"};

    String[] regions = {"Абыйский улус", "Алданский улус", "Аллаиховский улус", "Амгинский улус", "Анабарский национальный (долгано-эвенкийский) улус",
            "Булунский улус", "Верхневилюйский улус", "Верхнеколымский улус", "Верхоянский улус", "Вилюйский улус",
            "Горный улус", "Жиганский национальный эвенкийский улус", "Кобяйский улус", "Ленский улус", "Мегино-Кангаласский улус",
            "Мирнинский район", "Момский национальный эвенский улус", "Намский улус", "Нерюнгринский улус", "Нижеколымский улус",
            "Нюрбинский улус", "Оймяконский улус", "Оленекский эвенкийский национальный улус", "Олекминский улус", "Среднеколымский улус",
            "Сунтарский улус", "Таттинский улус", "Томпонский улус", "Усть-Алданский улус", "Усть-Майский улус",
            "Усть-Янский улус", "Хангаласский улус", "Чурапчинский улус", "Эвено-Бытантайский национальный улус", "город Якутск"};

    String[] regionInformations = {"Расположен в Заполярье (географические координаты: 146°25’ восточной долготы и 68°32’ северной широты), на Колымской низменности. Граничит с Аллаиховским, Среднеколымским, Верхнеколымским, Момским и Усть-Янским улусами. Территория — 69,4 тыс. км². По территории района протекает одиннадцатая по длине река России — Индигирка и река Уяндина. В районе находятся следующие населённые пункты — Сутуруоха, Куберганя, Абый, Сыаганнах, Кенг-Кюель. Здесь также расположено очень много мелких и крупных озёр (около 12000), из которых самое крупное — озеро Ожогино. Ландшафт в основном представлен лесотундрой, в растительности преобладает даурская лиственница. Абыйский район образован 25 мая 1930 года. Первоначально центром района было село Абый. 10 января 1941 года центр был перенесён в село Дружино (позже — пгт Дружина). В 1974 году центр района перенесён в пгт Белая Гора.",
            "Район расположен на юге республики Саха (Якутия), на Алданском щите. На поверхность выходят древнейшие кристаллические образования горных пород с возрастом более 3 миллиардов лет. Площадь района — 156,8 тыс. км². Самая высокая точка района — 2 264 м (гора у истоков р. Гонам). Крупные реки района: Алдан, Унгра, Тимптон, Гонам, Учур, Амга. Все реки обладают быстрым течением, изобилуют перекатами и порогами. По проходимости относятся к III и IV категории сложности, судоходный участок реки Алдан составляет 1 763 км. Долины рек практически безлюдны и слабо освоены. Согласно оценке природных условий жизни населения район значительно уступает равнинным территориям Центральной и Северо-Западной Якутии, лежащим до 1000 км севернее. По данным медикогеографического районирования территория относится к дискомфортным с затрудненной компенсацией, рекомендуемый срок проживания пришлых контингентов от 3 до 6 лет, полная адаптация возможна только для коренного населения, а оно составляет незначительную долю населения: 3,86 % — якуты, 4,11 % — эвенки. Район образован 5 мая 1930 года. 18 июля 1959 года к Алданскому району был присоединён Учурский район",
            "Расположен на северо-востоке республики, за Северным полярным кругом, в низовьях реки Индигирка. Большую часть улуса занимает Яно-Индигирская и Колымская низменности, на юге — Полоусный кряж, хребет Улахан-Сис, на востоке — Кондаковская возвышенность. Площадь района — 107,3 тыс. км². Крупные реки — Индигирка с многочисленными притоками, pеки Аллаиха, Бёрёлёх, Большая Эрча, Хрома, Шандрин и др. Много озёр, наиболее крупные из них — Моготоево, Ожогино, Бакул, Солунтах и др. Район образован в 1931 году.",
            "Расположен на юго-востоке Центральной Якутии. Граничит на севере с Чурапчинским улусом, на востоке и юго-востоке — с Усть-Майским, на юге и западе — с Алданским районом, на северо-западе — с Хангаласским и Мегино-Кангаласским улусами. Площадь района — 29,4 тыс. км². Центр улуса — Амга, основан в 1652 году как Амгинская слобода русскими крестьянами-хлебопашцами. Один из первых районов Якутии, где местные жители приобщились к культуре земледелия. В начале 1880-х гг. в Амге отбывал ссылку Владимир Короленко. 12 декабря 1911 года по решению Сената Российской империи Амгинский улус был выделен из Ботуруского улуса. В современных границах образован 9 января 1930 года.",
            "Анабарский улус расположен на крайнем северо-западе Республики Саха между 71-й и 76-й градусами северной широты. Улус занимает обширную территорию в 55,6 тыс. км² и граничит с Булунским и Оленекским улусами республики, а также Таймырским районом Красноярского края. Крупные реки — Анабар, Уэле. Крупные озёра — Улахан-Кюель, Баганытта-Кюель, Саппыя. 10 декабря 1930 года Президиум Всероссийского Центрального Исполнительного Комитета постановило образовать на территории расселения малых народностей Севера в составе Якутской АССР Анабарский национальный (эвенкийский) район (районный центр — Уджа). Постановление было подписано Председателем ВЦИК М. И. Калининым. Анабарский улус до сих пор сохраняет статус национального района. С 1 января 2003 года в Анабарском районе проводится муниципальная реформа. Анабарский улус в январе 2004 года первым из муниципальных образований Якутии получил свидетельство № 004393 о внесении в федеральный реестр муниципальных образований, подтверждающий национальный статус.",
            "Расположен на севере Якутии, в низовьях рек Лена, Оленёк и Омолой. Относится к арктической группе улусов республики. В состав улуса входят Новосибирские острова. Граничит на востоке с Усть-Янским и Верхоянским улусами на юге — с Эвено-Бытантайским и Жиганским, на западе — с Оленёкским и на северо-западе — с Анабарским. На севере и северо-востоке омывается водами моря Лаптевых, Новосибирские острова — Восточно-Сибирским морем.Это один из наиболее крупных улусов республики Саха. Район образован 10 декабря 1930 года, по постановлению ВЦИК СССР о ликвидации Булунского округа и образовании на его базе четырёх национальных районов. Центром Булунского района стало село Кюсюр. В 1957 году центр был переведён в Тикси. 18 июля 1959 года к Булунскому району была присоединена часть территории упразднённого Усть-Янского района.",
            "Граничит на севере с Оленёкским, на северо-востоке с Вилюйским, на юго-востоке с Горным, на юге с Олекминским, на юго-западе с Сунтарским, на западе с Нюрбинским улусами. Площадь территории района — 42 050 км². Расположен на среднем течении реки Вилюй[5]. Большие притоки, протекающие по территории улуса: Чыбыда, Тюкэн, Тонгуо. Как и большинство территории северной и центральной Якутии, лежит в области «вечной мерзлоты». Климат резко континентальный, зимой температура доходит до 60 градусов ниже нуля по Цельсию, летом — до +33. В письменных источниках впервые упоминается в связи с приходом русских казаков на берега Вилюя в начале XVII века. Мангазейские казаки во главе с Воином Шаховым поставили т. н. Верхневилюйское зимовье на левом берегу Вилюя, в месте впадения реки Тюкэн. В 60-х годах XVII века на этом месте была церковь, комиссарство, казначейство и 7 жилых домов.",
            "Расположен на северо-востоке республики. Большая часть территории района занята Колымской низменностью. На востоке расположено Юкагирское плоскогорье, а на западе — отроги хребта Черского. На юго-западе — хребет Арга-Тас, Осалинский кряж, на северо-западе — Ожогинский дол. Площадь района — 67,8 тыс. км². Соседями являются Момский, Абыйский, Среднеколымский районы и Среднеканский район Магаданской области. Климат в районе резко континентальный, с холодной, продолжительной зимой и коротким, сравнительно тёплым, летом. Колебания температуры больше 90 градусов, а среднегодовая температура отрицательная (-11,7 градусов по Цельсию). Район образован 30 апреля 1954 года. Документальная (писаная) история района начинается с 1647 года, после того как в 1643 году объединённые отряды Семёна Дежнёва, Дмитрия Зыряна и Михаила Стадухина направлились с Алазеи на Колыму. В 1647 году на берегу реки Ясачной, впадающей в Колыму, было построено первое Верхнеколымское зимовье, позже ставшее казачьим острогом и крепостью, затем селом. Сюда в 1826 году был доставлен декабрист Михаил Александрович Назимов. С 1868 года село Верхнеколымск стало центром христианизации местного населения.",
            "Площадь района — 134,4 тыс. км². Расположен на севере Якутии. Граничит на востоке с Момским районом, на юго-востоке — с Томпонским, на юго-западе — с Кобяйским улусом, на западе — с Эвено-Бытантайским, на северо-западе — с Булунским и на севере, северо-востоке — с Усть-Янским улусом. Юг и центральную часть занимает Янское плоскогорье, на северо-западе — хребет Кулар, на востоке — горные цепи хребта Черского. Территория улуса орошается рекой Яна и её притоками, Адыча (один из главных) и Туостаах. В среднем течении Яны на 68° с. ш. находится верхнепалеолитическая стоянка Бунге-Толля 1885, датируемая возрастом 47 тыс. лет. В 1954 году центр района был перенесён из Верхоянска в Батагай. 18 июля 1959 года к Верхоянскому району была присоединена часть территории упразднённого Усть-Янского района.",
            "Расположен на западе республики, на Центрально-Якутской равнине. Площадь района — 55,2 тыс. км². Крупная река — Вилюй с притоком р. Тюнг. Много озёр, наиболее крупное из них — Мастах. Район (улус) образован 9 января 1930 года. Вилюйский улус богат давними культурными традициями. Здесь одними из первых в Якутии открылись библиотека, краеведческий музей, Народный дом, детская музыкальная школа, Дом хомуса, музей боевой славы. Вилюйская земля является родиной таких выдающихся личностей, как М.Н.Жирков, Е.П. Степанова, И.Л. Кондаков, П.Х. Староватов, трех Героев Советского Союза: Н.С. Степанова, Н.А. Кондакова, А.А. Миронова; шести Героев Социалистического Труда и народных артистов Республики Саха (Якутия): Г.С. Васильева, А.П. Павлова, А.В. Егорова; народных поэтов: И.М. Гоголева (Кындыл), М.Е. Тимофеева. Свой творческий путь в Вилюйске начинали первый профессиональный театральный художник Г.М. Туралысов и первый режиссер национальной театральной труппы Д.Д. Большев. Советский период истории Вилюйского района начался 9 января 1930 года, когда был сформирован административный центр Вилюйск. В 2014 году отмечается его 380-летний юбилей. Муниципальное объединение «Вилюйский улус (район)» образовано в результате проведения местного референдума 29 сентября 2000 года.",
            "Расположен в Центральной Якутии. Площадь — 45,6 тыс. км². Большая часть улуса расположена на Приленском плато. На севере — Центрально-Якутская равнина. Крупные реки района — Синя, Ситте, Тюгюэне (левые притоки р. Лена). Граничит с 6 улусами. Район образован 25 июня 1931 года.",
            "Площадь — 140,2 тыс. км². Расположен на севере Якутии. Граничит на севере с Булунским улусом, на востоке — с Эвено-Бытантайским, на юго-востоке — с Кобяйским, на юго-западе — с Вилюйским и на западе — с Оленёкским улусами. Центр улуса, Жиганск, был основан в 1632 году отрядом русских казаков под предводительством Петра Бекетова. В 1783 году Жиганск обрёл статус города, став центром Жиганского уезда Якутской области. В 1805 году Жиганский уезд был упразднён, Жиганск вошёл в состав Верхоянского округа и статус города утратил. В 1822 году образован Жиганский улус в составе Верхоянского округа. В 1924 году образован Булунский округ Якутской АССР, который включал также территорию Жиганского улуса. 10 декабря 1930 года образован Жиганский национальный (эвенкийский) район. Впоследствии статус национального района был отменён. В 2008 году улус вновь получил статус эвенкийского национального.",
            "Площадь — 107,8 тыс. км². Расположен в северной части Центральной Якутии. Граничит на севере с Эвено-Бытантайским улусом, на северо-востоке — с Верхоянским, на востоке — с Томпонским районом, на юге — с Усть-Алданским, Намским и Горным улусами, на западе — с Вилюйским и на северо-западе — с Жиганским. Территория улуса издавна была заселена эвенами, эвенками и якутами. Кобяйский район образован 20 апреля 1937 года из отдалённых населённых пунктов Намского, Горного и Вилюйского районов с центром в селе Кобяй. В 1959 году административный центр был перенесён в Сангар. В 1962 году были присоединены Себян-Кюёльский, Сеген-Кюёльский наслеги упразднённого Саккырырского района.",
            "Расположен на юго-западе республики, в пределах Приленского плато. Площадь района — 77,0 тыс. км². Крупная река Лена с притоками: Витим, Нюя, Пеледуй. Район образован 30 января 1930 года.",
            "Площадь — 11,7 тыс. км². Граничит на севере с Усть-Алданским улусом, на северо-востоке — с Чурапчинским, на юго-востоке — с Амгинским, на юго-западе — с Хангаласским, на западе — с городским округом Якутск. Это самый маленький по площади улус Республики Саха. Его площадь более чем в 27 раз меньше самого большого по площади улуса в республике — Оленёкского улуса, но в то же время площадь улуса сопоставима с площадью Израиля. Образован 10 февраля 1930 года. Объединил два старинных якутских улуса — Мегинский и Восточно-Кангаласский. 8 ноября 2007 года Государственное Собрание (Ил Тумэн) РС(Я) приняло закон о переносе центра улуса из села Майя в Нижний Бестях.",
            "Площадь — 165,8 тыс. км². Граничит на севере и северо-востоке с Оленёкским улусом, на востоке — с Нюрбинским и Сунтарским улусами, на юге — с Ленским районом и на западе — с Иркутской областью и Красноярским краем. В этом районе находится одна из крупных аномальных долин — Елюю Черкечех. Первый (официальный) алмаз в Якутии был найден в 1949 году на Вилюе геологической партией Г. Х. Файнштейна. В 1949—1953 гг. были найдены алмазные россыпи в промышленных концентрациях в речных отложениях Вилюя и его многочисленных притоков, а также реки Оленёк. Находки алмазов в отложениях рек были связаны с практиковавшейся тогда методикой поиска алмазов, которая в основном опиралась на промывку и обработку речных галечников и песков, добывавшихся со дна реки или из шурфов на берегу. Однако эта методика не давала ответа, где находятся коренные месторождения — кимберлитовые трубки. В 1969 году открыта трубка «Интернациональная», лучшее в мире месторождение по стоимости алмазов в тонне руды. Мирнинский район образован 12 января 1965 года из части территорий Ленского, Сунтарского и Оленёкского районов. В 1930 году был образован Садынский район, включающий в себя часть территории современного Мирнинского района. В его состав входили Ботуобинский, Садынский, Чуонинский наслеги. В 1948 году район был ликвидирован. Первый наслег был передан в состав Ленского района, оставшиеся два — в состав Сунтарского.",
            "Расположен на северо-востоке Якутии. На территории района расположена высшая точка хребта Черского — гора Победа. Площадь — 104,6 тыс. км². Образован район 20 мая 1931 года. До этого входил в Верхоянский округ, куда входили Момский, Аллаиховский и Абыйский наслеги.",
            "Расположен в Центральной Якутии. Площадь — 11,9 тыс. км². Рельеф равнинный, улус расположен в пределах Центрально-Якутской равнины. Средняя температура января —42 °C, июля +17…+18 °С. Осадков выпадает около 200—250 мм в год. Крупнейшая из протекающих по территории улуса река — Лена, с многочисленными мелкими притоками. Улус располагает месторождениями кварцевого песка, строительных материалов (суглинок, песок). Намский улус (район) в нынешних границах образован 10 февраля 1930 года. В конце 20-х гг. XVII в. русские казаки собирали ясак не только на Лене, но и на её притоках. Самым известным из предводителей этих отрядов был енисейский служилый человек, сотник Пётр Бекетов. Именно он первым построил острог и основал г. Якутск. Ему принадлежит честь приведения в подданство Русского государства большинства якутских улусов. Он принял шерть-присягу на имя царя тридцати пяти якутских князцов. Среди них известно имя Намского князца Мымаха Минюева. На его земле в местности Чымаадай был построен первый острог в сентябре 1632 г. Как свидетельствуют источники, именно Мымах был первым якутским главой, который выбрал путь мирного сосуществования с Русским государством.",
            "Площадь района — 98,9 тыс. км². Нерюнгринский район занимает исключительно выгодное географическое положение, располагаясь близко к Транссибирской магистрали и портам Охотского моря. По территории района проходят федеральная автомобильная дорога «Лена», протяженностью 1232 км, а также строящаяся в настоящее время железная дорога «Беркакит — Томмот — Якутск». Нерюнгринский район возник в 1976 году, после образования в ноябре 1975 года промышленного центра Нерюнгри. В 1977 году к поселку Беркакит в 15 километрах от города была проведена железнодорожная ветка Тында-Беркакит. Тогда же в районе появилась сеть ГРЭС (Чульманская ГРЭС, СБГРЭС, Нерюнгринская ГРЭС), которая долгое время была энергетическим центром всего Дальнего Востока. Началась разработка угольных месторождений и месторождений золота, продолжающаяся и по сей день и являющаяся основой экономики Нерюнгинского района. В 1980—1990 годах была проложена железная дорога до самого Нерюнгри и дальше, до Алданского района (г. Томмот). В 2008 году Нерюнгринский муниципальный район образован вновь. В его состав вошли г. Нерюнгри и подчинённые его администрации населённые пункты, однако код ОКАТО не присвоен, код ОКТМО 98660000.",
            "Район расположен на крайнем северо-востоке Якутии, на Колымской низменности, на правом берегу Колымы. С севера омывается водами Восточно-Сибирского моря. Крупные реки — Колыма, Алазея, Большая Чукочья, Малая Куропаточья. Много озёр, наиболее крупные из них — Нерпичье, Чукочье, Большое Морское, Илиргыткин. Образован в 1930 году в составе Чукотского НО под названием район Западной тундры (центр — Нижнеколымск). В 1931 году передан в состав Якутской АССР. 10 января 1941 года центр района был перенесён из Нижнеколымска в Нижние Кресты.",
            "Площадь района — 52,4 тыс. км². Протяженность района с севера на юг составляет 275 км, а с запада на восток — 187 км. Район граничит на севере с Оленёкским районом, на востоке — с Верхневилюйским, на юге и юго-западе — с Сунтарским районом и на северо-западе — с Мирнинским районом. По мнению многих этнографов нюрбинцы происходят от хангаласского племени якутов. Это хорошо видно на исторических названиях наслегов Нюрбинского улуса: Кангаласский, Жарканский, Бордонский, Малджагарский и т. д. Улус получил своё название от озера Нюрба (як. Ньурба), на берегу которого жила девушка Джархан (як. Дьаархан), почитаемая как родоначальница нюрбинских и сунтарских якутов. По легендам, собранными Ксенофонтовым Г. В., племя, к которому принадлежала Джархан, было уничтожено воинственными туматами. Приняв участие в лучном бою наравне с мужчинами, девушка бежит на лодке-берестянке и укрывается в долине Туймаада, найдя приют у Мунньан Дархана — отца исторически известного Тыгына. Джархан вышла замуж за Мунньан Дархана и родила трёх сыновей: Быркынаа Боотур, Тойук Булгудах и Босхон Бэлгэтии. По мнению многих этнографов нюрбинцы происходят от хангаласского племени якутов. Это хорошо видно на исторических названиях наслегов Нюрбинского улуса: Кангаласский, Жарканский, Бордонский, Малджагарский и т. д.",
            "Площадь района — 92,3 тыс. км². Расположен на востоке Якутии. Это 14-й среди наибольших по размеру улусов республики Саха. Граничит на юго-западе с Усть-Майским улусом, на западе — с Томпонским улусом, на севере — с Момским улусом, на востоке — с Магаданской областью и на юге — с Хабаровским краем. В селе Оймякон находится полюс холода, где была зафиксирована одна из самых низких температур в северном полушарии −71,2 °C. Оймяконский район образован 20 мая 1931 года. 28 июня 1920 года Оймяконская волость отделилась от Баягантайской волости на основании Протокола заседания Якутского Райревкома от 28 июня 1920 года № 17. В 1954 году центр района был перенесён из села Оймякон в пгт Усть-Нера. В 1990 году Ючюгейский наслег был выделен из Борогонского 2-го наслега. В 2001 году упразднён Арга-Мойский наслег, состоявший из одного села Арга-Мой. В 2002 году были упразднены административно-территориальные единицы «посёлок Ольчан» (состоявший из посёлков Ольчан и Октябрьский), «посёлок Сарылах».",
            "Площадь района — 318,0 тыс. км² — самый большой по площади район (улус) Якутии: его площадь более чем в 27 раз больше Мегино-Кангаласского улуса, самого малого по площади в Республике Саха. Расположен на северо-западе республики, за Северным полярным кругом, в бассейнах рек Оленёк и Анабар. Образован 1 октября 1935 года. Наделён статусом эвенкийского национального района в 2005 году.",
            "Расположен на юго-западе Якутии, на Сибирской платформе, большая часть которой сложена из известняков и мергелей. Рельеф плоскогорный. Большую часть улуса занимают Олёкмо-Чарское и Чугинское плоскогорья, на севере — Приленское плато, на юге — северная часть хребта Удокан. Средняя температура января от −30 °С до −35 °С, июля от +12 °С в горах до +18 °С в долине. Осадков выпадает в год от 200 до 300 мм. Крупная река — Лена (с многочисленными притоками, наиболее крупный из них — р. Олёкма). Датой рождения Олекминска считается 1635 год, когда казаки поставили крепость на левом берегу Лены. Для управления Олёкминским округом и разрешения споров между жителями в 1775 году было учреждено комиссарство, в 1738 году Олекминск стал уездным городом Якутской области, в 1882 году переименован в окружной. Городом и округом ведало полицейское управление в лице исправника, его помощника и секретаря. В 1843 году в Олекминске были 31 дом и юрта. Появились сословия: духовное, разночинцы, мещане и купцы, казаки. Образован район 9 января 1930 года. В 1936 году Чаринский и Ярханский сельсоветы были переданы из Олёкминского района в новый Токкинский район. В 1953 году Токкинский район был упразднён, а его территория включена в Олёкминский район.",
            "Площадь района — 125,2 тыс. км². Граничит на юге с Верхнеколымским улусом, на западе — с Абыйским улусом, на северо-западе — с Аллаиховским улусом, на севере — с Нижнеколымским улусом, на востоке — с Чукотским автономным округом и на юго-востоке — с Магаданской областью. Преобладает равнинный рельеф. Значительную часть улуса занимает Колымская низменность. На западе — Алазейское плоскогорье, на востоке — Юкагирское плоскогорье. По территории улуса протекают реки Колыма и Алазея. Множество озёр. В северо-восточной части улуса расположен природный парк «Колыма». Улус (район) образован 25 мая 1930 года.",
            "Площадь — 57,8 тыс. км². Улус расположен в среднем течении реки Вилюй. Граничит на севере и северо-востоке с Нюрбинским улусом, на востоке — с Верхневилюйским на юго-востоке — с Олёкминским, на юго-западе — с Ленским, на западе — с Мирнинским. Рельеф плоскогорный. На севере улуса — Вилюйское плато, на юге — Приленское плато. Якуты заселили территорию Сунтарского улуса в 9 веке. Они принадлежали к Нерюктяйскому роду, который с начала 9 века переселился с Байкала. Начиная с 17 века этот наслег распался на три наслега: 1-й Нерюктяйский наслег (с. Тойбохой, с. Усун-Кел, с. Мар-Кел, с. Аллана), 2-й Нерюктяйский наслег (с. Нерюктяй, с. Тюбяй, с. Ыгыатта, с. Мэлэкэ, с. Шея, с. Кутана, с. Тюбей-Жархан, с. Кюкей) и 3-й Нерюктяйский населег (с. Бордон, с Хадан). Центр Сунтарского улуса был образован примерно в те же времена в районе озера Сунтар. Первым прибывшим в Сунтар русским землепроходцем был Ерофей Хабаров приблизительно в 1632—1636 г. Воин Шахов на разработку Кемпендяйской соли прибыл в Сунтар в 1640 г., первая администрация российской империи была создана в том же году им же, и им же были построены первые укрепленные зимовья на территории Сунтарского улуса. С первых лет колонизации Якутии богатая плодородная сунтарская долина притягивала к себе служилых людей. Особую ценность представляли меха и кемпендяйская соль. В 1736 году для изучения соляных источников приезжал Степан Петрович Крашенинников. Дата образования улуса — 9 января 1930 года. В 1965 году часть территории района была передана в новообразованный Мирнинский район.",
            "Территория района составляет 18 984 км². Расположен на северо-востоке центральной части Якутии. День образования Таттинского улуса утвержден решением улусного Совета депутатов №51-4 от 19 июня 2018 г. Днем образования Таттинского улуса считается 8 декабря 1912 г. Данное событие отмечается по Григорианскому календарю 21 декабря. Гимн утвержден решением улусного Совета депутатов №57-1 от 13 декабря 2012 г. Слова Софронова Анемподиста Ивановича — Алампа, мелодия Протодьяконова Василия Николаевича «Саха ырыата». Флаг утвержден решением улусного Совета депутатов Таттинского улуса № 7-2 от 29 января 2009 г. Автор флага: Лопатин Афанасий Петрович. Флаг утвержден решением улусного Совета депутатов Таттинского улуса № 7-2 от 29 января 2009 г. Автор флага: Лопатин Афанасий Петрович.",
            "Расположен район на востоке республики. Площадь — 135,8 тыс. км². Крупные реки: Алдан с многочисленными притоками — Томпо, Хандыга и др., верховья р. Адычи. Территория района в основном расположена в среднем течении реки Алдан и в бассейне её притока — реки Томпо, откуда название района. Томпонский район был образован 20 мая 1931 года из четырёх наслегов: Таттинского, Верхоянского и двух наслегов Оймяконского района. По своему географическому положению, по составу населения эти наслеги должны были образовать вновь созданный национальный район[источник не указан 3087 дней], где основным населением были эвены, которые вели кочевой образ жизни, занимались оленеводством и охотой. В 1954 году центр района был перенесён из села Крест-Хальджай в пгт Хандыга.",
            "Площадь района — 18,3 тыс. км². Расположен в Центральной Якутии, невдалеке от Якутска. Граничит на востоке с Таттинским улусом, на юго-востоке — с Чурапчинским, на юге — с Мегино-Кангаласским, на западе — с Намским, на севере — с Кобяйским, на северо-востоке — с Томпонским районом. Усть-Алданский улус образован 9 января 1930 года на землях борогонских якутов. Борогонцы — один из двух (наряду с кангаласцами) старших родоплеменных союзов якутов. По одной из версий, название борогон происходит от имени тюрко-монгольского племени борджигин, в котором родился Чингисхан. Считается, что Борогонский улус сформировался к началу XIII века. В 1815 году из него выделился Дюпсинский улус. В нынешнем виде Усть-Алданский улус включает территории обоих улусов, а также часть Баягантайского улуса. 18 сентября 1789 года состоялся приём императрицей Екатериной II головы Борогонского улуса Алексея (Сэсэн) Аржакова, который представил императрице «План о якутах с показанием казённой пользы и выгоднейших положениев для них». Обсуждение «Плана о якутах» на заседании Государственного Совета Российской Империи прошло 1 октября 1789 года. В Усть-Алданском улусе родились Герой Советского Союза Владимир Денисович Лонгинов и представленный к Герою Советского Союза — Герой России Михаил Михайлович Стрекаловский. ",
            "Улус расположен на востоке республики и находится в 200 км от полюса холода Северного полушария. Климат суровый, резко континентальный. Реки: Алдан и её притоки Мая, Джунекян и Аллах-Юнь. Район образован 20 мая 1931 года на территории Майского ведомства Якутской области. В 1937—1948 годах район был разделён на Аллах-Юньский (с центром в Аллах-Юнь) и Усть-Майский районы. В 1972—1992 годах центром района был посёлок Солнечный.",
            "Расположен район на севере Якутии. Площадь — 120,3 тыс. км². По территории улуса протекают реки Яна, Омолой, Чондон и др. Крупнейшие озёра: Бустах, Оротко. Улус имеет выход к морю Лаптевых. Район образован в 1930-е годы. 18 июля 1959 года район был упразднён, а его территория разделена между Булунским и Верхоянским районами. 5 мая 1967 года район был восстановлен.",
            "Площадь района — 24,7 тыс. км². Граничит на востоке с Мегино-Кангаласским улусом, на юге — с Амгинским и Алданским районами, на юго-западе — с Олёкминским районом, на севере — с Горным улусом и городским округом города Якутск. Наименование «Хангаласский» отражается в документах с 1632 года, то есть со времен прихода в Якутию русских казаков. В 1860 году обширный Хангаласский улус разделился на два улуса — Западно-Кангаласский и Восточно-Кангаласский. В нынешних границах улус образован 10 февраля 1930 года, ему было дано название Западно-Кангаласский район, в 1937 году был переименован в Орджоникидзевский, в честь отбывавшего здесь ссылку Серго Орджоникидзе. Исконное название было возвращено в 1992 году.",
            "Расположен в Центральной Якутии. Большая часть улуса находится на Приленском плато. Через улус протекает река Амга. Много озёр, самое крупное озеро — Чурапча. Зимы холодные. Средняя температура января — 42 °C, июля +16…+17 °C. Годовое количество осадков 200—250 мм. В период Гражданской войны, в июле 1922 года произошла расправа над сторонниками красного движения и их семьями, вошедшая в историю как «Чурапчинская колотушка». Улус (район) образован 25 марта 1930 года.",
            "Расположен улус на севере республики, за Северным полярным кругом, между реками Леной и Яной. Запад района занимает Верхоянский хребет, северо-восток — хребет Кулар. Является одним из самых труднодоступных улусов Якутии. Площадь района — 52,3 тыс. км². Эвено-Бытантайский улус (район) является самым молодым по времени образования из ныне существующих в республике. Постановлением Президиума Верховного Совета Якутской АССР от 21 апреля 1989 года из состава Верхоянского района выделен и образован Эвено-Бытантайский национальный улус (район).",
            "Округ находится в Центральной Якутии. Занимает территорию не только долины Туймаада — исторического центра Якутии, но и обширных земель к западу от неё. Общая площадь территории городского округа — 3,6 тыс. км². Граничит: на западе — с Горным улусом, на севере — с Намским улусом, на востоке — с Мегино-Кангаласским улусом, на юге — с Хангаласским улусом Якутии. Территория округа примыкает с запада к реке Лене, восточная его граница проходит по рукавам Лены. В советское время данная территория обозначалась как территория, подчинённая Якутскому городскому Совету. Этот городской Совет с подчинённой территорией был образован в 1922 году. В постсоветское время ей первоначально соответствовала административно-территориальная единица город республиканского значения Якутск, в границах которой в рамках реформы местного самоуправления было создано муниципальное образование городской округ «город Якутск». 3 ноября 2004 года на основании постановлений Государственного Собрания (Ил Тумэн) Республики Саха (Якутия) посёлки Марха и Кангалассы были включены в городскую черту Якутска. Законом Республики Саха (Якутия) от 30 ноября 2004 года «Об установлении границ территорий и о наделении статусом городского округа муниципальных образований Республики Саха (Якутия)» было закреплено, что муниципальное образование «Жатай» является самостоятельным и единым муниципальным образованием, не входящим в состав городского округа «Город Якутск». Таким образом, посёлок Жатай, фактически примыкающий к городу с севера, в его состав не входит и образует отдельный городской округ, территория которого со всех сторон окружена территорией ГО «Город Якутск». В то же время, самый удалённый от города посёлок Кангалассы входит теперь не только в ГО, но и непосредственно в городскую черту и официально называется «Микрорайон Кангалассы»"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button btn_back = findViewById(R.id.btn_back);

        ConstraintLayout constraintLayout = findViewById(R.id.regionInfo);

        TextView regionName  = findViewById(R.id.txtRegionName);
        TextView regionInfo = findViewById(R.id.txtRegionInfo);

        RichPathView richPathView = findViewById(R.id.map);
        richPathView.setOnPathClickListener(new RichPath.OnPathClickListener() {
            @Override
            public void onClick(RichPath richPath) {
                if (canClick && Arrays.asList(regionNumbers).contains(richPath.getName())) {
                    canClick = false;

                    constraintLayout.setVisibility(View.VISIBLE);

                    btn_back.setVisibility(View.GONE);

                    int index = Arrays.asList(regionNumbers).indexOf(richPath.getName());

                    regionName.setText(regions[index]);
                    regionInfo.setText(regionInformations[index]);
                }
            }
        });

    }
    //Системная кнопка
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(GameLevels.this, Menu.class);
        startActivity(intent);
        finish();
    }

    public void Back(View view) {
        Intent intent = new Intent(GameLevels.this, Menu.class);
        startActivity(intent);
        finish();
    }

    public void CloseInfo(View view) {
        canClick = true;

        ConstraintLayout constraintLayout = findViewById(R.id.regionInfo);
        constraintLayout.setVisibility(View.GONE);

        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setVisibility(View.VISIBLE);
    }
}