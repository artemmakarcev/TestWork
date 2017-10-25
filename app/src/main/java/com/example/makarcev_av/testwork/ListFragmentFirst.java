package com.example.makarcev_av.testwork;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.makarcev_av.testwork.POJO.GetAll;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListFragmentFirst extends ListFragment {


    String[] vseDep = null;
    private List<GetAll> getAllItems = new ArrayList<GetAll>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        for (int i = 0; i < employeeItems.size(); i++) {
//            Employee employeeItem = employeeItems.get(i);
//            vseDep[i] = employeeItem.getName();
//            Log.d("my_log", "Name:  " + employeeItem.getName());
//            Log.d("my_log", "Title:  " + employeeItem.getTitle());
//        }

//            vseDep = new String[getAllItems.size()];
//            for (int i = 0; i < getAllItems.size(); i++) {
//                GetAll getAll = getAllItems.get(i);
//                vseDep[i] = getAll.getName();
//                Log.d("my_log", "Name:  " + getAll.getName());
//            }

        try {
            JSONObject jsonAll = null;
            jsonAll = new JSONObject("{\"ID\":\"0\",\"Name\":\"Все\",\"Departments\":[{\"ID\":\"18\",\"Name\":\"IT офис\",\"Employees\":[{\"ID\":\"4647\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Менеджер по проектам\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"7935\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Менеджер по проектам\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"4648\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Руководитель проектов\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"}]},{\"ID\":\"99\",\"Name\":\"Авиа\",\"Departments\":[{\"ID\":\"305\",\"Name\":\"Отдел 1\",\"Employees\":[{\"ID\":\"8388\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Авиационный техник авиационного и радиоэлектронного оборудования\",\"Phone\":\"+79991112222\"},{\"ID\":\"3906\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Авиационный техник ГСМ\",\"Phone\":\"+79991112222\"},{\"ID\":\"2553\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Автомеханик\",\"Phone\":\"+79991112222\"},{\"ID\":\"8981\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Инженер летательных аппаратов и двигателей\",\"Phone\":\"+79991112222\"},{\"ID\":\"4527\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Инженер\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"3460\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Инженер по сертификации\",\"Phone\":\"+79991112222\"},{\"ID\":\"3992\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Авиационный техник\",\"Phone\":\"+79991112222\"},{\"ID\":\"7635\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Авиационный техник летательных аппаратов и двигателей\",\"Phone\":\"+79991112222\"},{\"ID\":\"3918\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Главный инженер\",\"Phone\":\"+79991112222\"},{\"ID\":\"3991\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Инженер авиационного и радиоэлектронного оборудования\",\"Phone\":\"+79991112222\"},{\"ID\":\"4013\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Авиационный техник авиационного и радиоэлектронного оборудования\",\"Phone\":\"+79991112222\"}]},{\"ID\":\"306\",\"Name\":\"Отдел 2\",\"Employees\":[{\"ID\":\"5101\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Механик\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"8063\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Менеджер по работе с клиентами\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"1944\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Заместитель директора по летной работе\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"2820\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Экономист\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"1910\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Заместитель директора по общим вопросам\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"2652\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Командир парашютного звена\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"4175\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Директор\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"2752\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Начальник штаба\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"2766\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Бухгалтер\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"2827\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Директор\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"7155\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Начальник штаба\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"3459\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Начальник инженерно-авиационной службы\",\"Phone\":\"+79991112222\"},{\"ID\":\"2950\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Комендант\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"4645\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Инженер ИАС\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"}]},{\"ID\":\"308\",\"Name\":\"Отдел 3\",\"Departments\":[{\"ID\":\"309\",\"Name\":\"Подотдел 1\",\"Employees\":[{\"ID\":\"8309\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Водитель\",\"Phone\":\"+79991112222\"}]},{\"ID\":\"310\",\"Name\":\"Подотдел 2\",\"Employees\":[{\"ID\":\"6137\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Авиационный техник\",\"Phone\":\"+79991112222\"},{\"ID\":\"7225\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Авиационный техник летательных аппаратов и двигателей\",\"Phone\":\"+79991112222\"}]},{\"ID\":\"311\",\"Name\":\"Подотдел 3\",\"Employees\":[{\"ID\":\"3840\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Пилот\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"4091\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Пилот\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"2813\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Врач\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"2869\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Пилот\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"2654\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Летчик-методист\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"6999\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Пилот\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"4178\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Пилот-инструктор\",\"Phone\":\"+79991112222\"},{\"ID\":\"2868\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Пилот\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"3915\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Пилот\",\"Phone\":\"+79991112222\"}]},{\"ID\":\"312\",\"Name\":\"Подотдел 4\",\"Employees\":[{\"ID\":\"8272\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Водитель\",\"Phone\":\"+79991112222\"},{\"ID\":\"4047\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Сторож\",\"Phone\":\"+79991112222\"},{\"ID\":\"2816\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Сторож\",\"Phone\":\"+79991112222\"},{\"ID\":\"6037\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Разнорабочий\",\"Phone\":\"+79991112222\"},{\"ID\":\"5805\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Повар\",\"Phone\":\"+79991112222\"},{\"ID\":\"4048\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Сторож\",\"Phone\":\"+79991112222\"},{\"ID\":\"8573\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Сторож\"},{\"ID\":\"11172\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Водитель\",\"Phone\":\"+79991112222\"},{\"ID\":\"3852\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Разнорабочий\",\"Phone\":\"+79991112222\"},{\"ID\":\"7680\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Повар\"},{\"ID\":\"5452\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Сторож\",\"Phone\":\"+79991112222\"},{\"ID\":\"3019\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Разнорабочий\",\"Phone\":\"+79991112222\"},{\"ID\":\"3483\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Сторож\",\"Phone\":\"+79991112222\"},{\"ID\":\"7684\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Кладовщик\",\"Phone\":\"+79991112222\"}]},{\"ID\":\"313\",\"Name\":\"Подотдел 5\",\"Employees\":[{\"ID\":\"2655\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Парашютист-инструктор\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"6252\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Парашютист-инструктор\",\"Phone\":\"+79991112222\"},{\"ID\":\"2817\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Уборщица\",\"Phone\":\"+79991112222\"},{\"ID\":\"6253\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Парашютист-инструктор\",\"Phone\":\"+79991112222\"},{\"ID\":\"2653\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Парашютист-инструктор\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"3672\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"мастер по ремонту парашютно-десантной техники\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"}]}]},{\"ID\":\"314\",\"Name\":\"Отдел 4\",\"Employees\":[{\"ID\":\"8780\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Старший инструктор парашютно-десантной подготовки\"},{\"ID\":\"8947\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Заведующий складом\"},{\"ID\":\"8793\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Инструктор парашютно-десантной подготовки\"},{\"ID\":\"8766\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Начальник штаба\"},{\"ID\":\"9701\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Бухгалтер\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"8767\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Инструктор парашютно-десантной подготовки\"},{\"ID\":\"8786\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Комендант аэродрома\"},{\"ID\":\"8784\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Инструктор парашютно-десантной подготовки\"},{\"ID\":\"9301\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Уборщица\"},{\"ID\":\"8775\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Инженер инженерно-авиационной службы\"},{\"ID\":\"8785\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Техник по радионавигации, радиолокации, связи\"},{\"ID\":\"8774\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Стрелок военизированной охраны\"},{\"ID\":\"8768\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Старший стрелок военизированной охраны\"},{\"ID\":\"8948\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Летчик-инструктор\"},{\"ID\":\"8773\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Стрелок военизированной охраны\"},{\"ID\":\"8776\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Командир отряда\"}]},{\"ID\":\"315\",\"Name\":\"Отдел 5\",\"Employees\":[{\"ID\":\"3458\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Инженер отдела технического контроля\",\"Phone\":\"+79991112222\"},{\"ID\":\"5901\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Заместитель директора по авиационной безопасности\",\"Phone\":\"+79991112222\"},{\"ID\":\"5811\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"инженер-инспектор по безопасности полетов\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"}]}]},{\"ID\":\"328\",\"Name\":\"Тест 1\"},{\"ID\":\"254\",\"Name\":\"გამოძახება\"},{\"ID\":\"35\",\"Name\":\"Тест 3\",\"Employees\":[{\"ID\":\"4650\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Руководитель офиса\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"4651\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Менеджер по работе с клиентами\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"9215\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Менеджер по работе с клиентами\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"7079\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Менеджер по работе с клиентами\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"10217\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Менеджер по работе с клиентами\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"},{\"ID\":\"4652\",\"Name\":\"Иванов Иван Иванович\",\"Title\":\"Менеджер по работе с клиентами\",\"Email\":\"test@yandex.ru\",\"Phone\":\"+79991112222\"}]},{\"ID\":\"716\",\"Name\":\"გამოძახება\"}]}");
            JSONArray depAll = jsonAll.getJSONArray("Departments");

            for (int i = 0; i < depAll.length(); i++) { //all
                JSONObject dep0 = depAll.getJSONObject(i);


                getAllItems.add(new GetAll(dep0.getInt("ID"), dep0.getString("Name")));
//                    Log.d(LOG_TAG, String.valueOf(depAll));

//                    if (dep0.has("Employees")) {//первые сотрудники
//                        JSONArray empAll = dep0.getJSONArray("Employees");
//                        for (int n = 0; n < empAll.length(); n++) {
//                            JSONObject emp0 = empAll.getJSONObject(n);
//                            employeeItems.add(new Employees(emp0.getInt("ID"), emp0.getString("Name"), emp0.getString("Title"), emp0.getString("Email"), emp0.getLong("Phone")));
//                        }
//                    } //первые сотрудники

//                    if (dep0.has("Departments")) {//отделы
//                        JSONArray dep1 = dep0.getJSONArray("Departments");
//                        for (int m = 0; m < dep1.length(); m++) {
//                            JSONObject dep2 = dep1.getJSONObject(m);
//
//                            if (dep2.has("Employees")) {//сотрудники в отделах
//                                JSONArray emp3 = dep2.getJSONArray("Employees");
//                                for (int x = 0; x < emp3.length(); x++) {
//                                    JSONObject emp4 = emp3.getJSONObject(x);
//                                }
//                            }//сотрудники в отделах
//                            if (dep2.has("Departments")) {//отделы в отделах
//                                JSONArray dep123 = dep2.getJSONArray("Departments");
//                                for (int y = 0; y < dep123.length(); y++) {
//                                    JSONObject dep321 = dep123.getJSONObject(y);
//
//                                    if (dep321.has("Employees")) {//сотрудники в Подотделах
//                                        JSONArray emp321 = dep321.getJSONArray("Employees");
//                                        for (int x = 0; x < emp321.length(); x++) {
//                                            JSONObject emp44 = emp321.getJSONObject(x);
//                                        }
//                                    }//сотрудники в Подотделах
//                                }
//                            }//отделы в отделах
//                        }
//                    }//отделы
            } //all

//                Log.d("my_log", employeeItems);

////        vseDep = new String[employeeItems.size()];
//                for (int i = 0; i < employeeItems.size(); i++) {
//                    Employees employeeItem = employeeItems.get(i);
////            vseDep[i] = employeeItem.getName();
//                    Log.d("my_log", "Name:  " + employeeItem.getName());
//                    Log.d("my_log", "Title:  " + employeeItem.getTitle());
//                }

            vseDep = new String[getAllItems.size()];
            for (int i = 0; i < getAllItems.size(); i++) {
                GetAll getAll = getAllItems.get(i);
                vseDep[i] = getAll.getName();
                Log.d("my_log", "Name:  " + getAll.getName());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        int n = 10;
//        String[] vseDep = new String[n];
//        for (int i = 0; i < n; i++) {
//            vseDep[i] = String.valueOf(i);
//        }

        ListAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, vseDep);
        setListAdapter(adapter);

//        Employee employeeItem = data.get(0);

//        vseDep = new String[5];
//        for (int i = 0; i < 5; i++){
//            Employee employeeItem = data.get(i);
//            vseDep[i] = employeeItem.getName();
//        }
//                ListAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, vseDep);
//        setListAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_fragment, container, false);

        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        OnSelectedItem itemListener = (OnSelectedItem) getActivity();
        itemListener.onItemSelected(position);

//        TextView textView = (TextView) v;
//        String itemText = textView.getText().toString(); // получаем текст нажатого элемента
//        Toast.makeText(getActivity(), "Вы выбрали " + itemText + " позиция " + position, Toast.LENGTH_SHORT).show();

//       if (position % 2 == 0) {
//            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+71234567890"));
////            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+71234567890"));
////            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+71234567890"));
////            intent.setData(Uri.parse("tel:" + "89129763460"));
////            startActivity(Intent.createChooser(intent, "Набор номера..."));
//            startActivity(intent);
////            //createChooser сегда вызыевает выбор приложения, даже если есть по умолчанию
//        } else {
//            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//            emailIntent.setType("plain/text");
//            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"test_user"});
//            startActivity(Intent.createChooser(emailIntent, "Отправка письма..."));
//        }

    }

//    int translateIdToIndex(int id) {
//        int index = 234;
//        return index;
//    }

    public interface OnSelectedItem {
        void onItemSelected(int itemIndex);
    }


}
