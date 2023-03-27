package org.example.Server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.dao.*;
import org.example.interfaces.*;
import org.example.model.*;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;

public class Worker implements Runnable {
    protected Socket clientSocket = null;
    ObjectInputStream sois;
    ObjectOutputStream soos;


    public Worker(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    ArrayList<String> history = new ArrayList<>();

    @Override
    public void run() {
        try {
            sois = new ObjectInputStream(clientSocket.getInputStream());
            soos = new ObjectOutputStream(clientSocket.getOutputStream());
            Role role = new Role();
            Staffing staffing = new Staffing();
            ReportCard reportCard = new ReportCard();
            FinalSalary finalSalary = new FinalSalary();
            FinalModel finalModel = new FinalModel();
            Taxes taxes = new Taxes();
            while (true) {
                System.out.println("Получение команды от клиента...");
                Gson gson = new Gson();
                String choice = (String) sois.readObject();
                System.out.println("Команда получена");
                switch (choice) {
                    case "authorization": {
                        history.add(choice);
                        System.out.println("Выполняется авторизация пользователя....");
                        String message = sois.readObject().toString();
                        UserSQL dao = new UserDAO();
                        RoleSQL rdao = new RoleDAO();
                        User user = gson.fromJson(message, User.class);

                        user = dao.getUser(user);
                        System.out.println("Введенные данные -> " + user);
                        role.setPersonID(user.getPersonID());
                        role = rdao.getRole(role);
                        System.out.println(role + " сработало!!");
                        if (role.getURole() != null) {
                            soos.writeObject("OK");
                            soos.writeObject(gson.toJson(role));
                            //soos.writeObject(user);
                        } else
                            soos.writeObject("There is no data!");
                        break;
                    }
                    case "registration": {
                        history.add(choice);
                        System.out.println("регистрация Worker....");
                        ////////////////////////////////////
                        String message = sois.readObject().toString();
                        String message1 = sois.readObject().toString();
                        ////////////////////////////////////
                        personSQL dao = new personDAO();
                        UserSQL dao1 = new UserDAO();
                        staffingSQL dao2 = new staffingDAO();
                        RoleSQL dao3 = new RoleDAO();
                        ReportCardSQL dao4 = new ReportCardDAO();
                        FinalSalarySQL dao5 = new FinalSalaryDAO();
                        TaxesSQL dao6 = new TaxesDAO();
                        ////////////////////////////////////
                        Person person = gson.fromJson(message, Person.class);
                        dao.RegPerson(person);
                        person = dao.getPerson(person);
                        ////////////////////////////////////
                        User user = gson.fromJson(message1, User.class);
                        user = dao1.getUser(user);
                        user.setPersonID(person.getID());
                        dao1.regUser(user);
                        user = dao1.getUser(user);
                        ////////////////////////////////////
                        role.setURole("Worker");
                        role.setPersonID(person.getID());
                        dao3.putRole(role);
                        dao3.getRole(role);
                        /////////////////////////////////////
                        staffing.setRoleID(role.getrID());
                        staffing.setPersonID(person.getID());
                        staffing.setCasing(250);
                        dao2.AddStaff(staffing);
                        /////////////////////////////////////
                        reportCard.setPersonID(person.getID());
                        reportCard.setName(person.getUserFName());
                        reportCard.setSurname(person.getUserLName());
                        reportCard.setDaysWorked(20);
                        dao4.AddReportCardInfo(reportCard);
                        /////////////////////////////////////
                        taxes.setPersonID(person.getID());
                        taxes.setUserTaxes(0);
                        dao6.insertTaxes(taxes);
                        /////////////////////////////////////
                        finalSalary.setPersonID(person.getID());
                        finalSalary.setRolesID(role.getrID());
                        finalSalary.setReportCardID(person.getID());
                        finalSalary.setTaxesID(person.getID());
                        finalSalary.setFS(0);
                        dao5.AddFSalary(finalSalary);


                        System.out.println("Введенные данные --> " + user + " " + person);
                        System.out.println("сработало!!");
                        if(!role.getURole().equals("")){
                            soos.writeObject(gson.toJson(person));
                            soos.writeObject(gson.toJson(user));
                            //soos.writeObject(gson.toJson(role));
                        }
                        break;
                    }
                    case "registrationHR": {
                        history.add(choice);
                        System.out.println("регистрация Human Resource....");
                        ////////////////////////////////////
                        String message = sois.readObject().toString();
                        String message1 = sois.readObject().toString();
                        ////////////////////////////////////
                        personSQL dao = new personDAO();
                        UserSQL dao1 = new UserDAO();
                        staffingSQL dao2 = new staffingDAO();
                        RoleSQL dao3 = new RoleDAO();
                        ReportCardSQL dao4 = new ReportCardDAO();
                        FinalSalarySQL dao5 = new FinalSalaryDAO();
                        TaxesSQL dao6 = new TaxesDAO();
                        ////////////////////////////////////
                        Person person = gson.fromJson(message, Person.class);
                        dao.RegPerson(person);
                        person = dao.getPerson(person);
                        ////////////////////////////////////
                        User user = gson.fromJson(message1, User.class);
                        user = dao1.getUser(user);
                        user.setPersonID(person.getID());
                        dao1.regUser(user);
                        user = dao1.getUser(user);
                        ////////////////////////////////////
                        role.setURole("HR");
                        role.setPersonID(person.getID());
                        dao3.putRole(role);
                        dao3.getRole(role);
                        /////////////////////////////////////
                        staffing.setRoleID(role.getrID());
                        staffing.setPersonID(person.getID());
                        staffing.setCasing(250);
                        dao2.AddStaff(staffing);
                        /////////////////////////////////////
                        reportCard.setPersonID(person.getID());
                        reportCard.setName(person.getUserFName());
                        reportCard.setSurname(person.getUserLName());
                        reportCard.setDaysWorked(20);
                        dao4.AddReportCardInfo(reportCard);
                        /////////////////////////////////////
                        taxes.setPersonID(person.getID());
                        taxes.setUserTaxes(0);
                        dao6.insertTaxes(taxes);
                        /////////////////////////////////////
                        finalSalary.setPersonID(person.getID());
                        finalSalary.setRolesID(role.getrID());
                        finalSalary.setReportCardID(person.getID());
                        finalSalary.setTaxesID(person.getID());
                        finalSalary.setFS(0);
                        dao5.AddFSalary(finalSalary);


                        System.out.println("Введенные данные --> " + user + " " + person);
                        System.out.println("сработало!!");
                        if(!role.getURole().equals("")){
                            soos.writeObject(gson.toJson(user));
                            soos.writeObject(gson.toJson(person));
                            //soos.writeObject(gson.toJson(role));
                        }
                        break;
                    }
                    case "StaffingOverview": {
                        history.add(choice);
                        System.out.println("Обзор Штатного расписания(VBox)...");
                        staffingSQL dao = new staffingDAO();
                        ArrayList<Staffing> list = dao.GetStaffingList();
                        System.out.println(list);
                        Type fooType = new TypeToken<ArrayList<Staffing>>() {}.getType();
                        soos.writeObject(gson.toJson(list, fooType));
                        break;
                    }

                    case "Users": {
                        history.add(choice);
                        System.out.println("Обзор пользователей системы...");
                        UserInfoSQL dao = new UserInfoDAO();
                        ArrayList<UserInfo> list = dao.get();
                        System.out.println(list);
                        Type fooType = new TypeToken<ArrayList<UserInfo>>() {}.getType();
                        soos.writeObject(gson.toJson(list, fooType));
                        soos.flush();
                        break;
                    }
                    case "DeleteUser": {
                        history.add(choice);
                        soos.flush();
                        String message = sois.readObject().toString();
                        personSQL dao1 = new personDAO();
                        UserSQL dao = new UserDAO();
                        Person person = gson.fromJson(message, Person.class);
                        dao1.DelPerson(person);
                        dao1.getPerson(person);
                        System.out.println("Был удален пользователь -> " + person.getID());
                        if (person.getID() != 0) {
                            soos.writeObject("OK");
                            soos.writeObject(gson.toJson(person));
                            soos.flush();
                            //soos.writeObject(user);
                        } else soos.writeObject("There is no data!");

                        break;
                    }
                    case "ReportCardOverview": {
                        history.add(choice);
                        System.out.println("Обзор Табеля(VBox)...");
                        ReportCardSQL dao = new ReportCardDAO();
                        ArrayList<ReportCard> list = dao.GetReportCardList();
                        System.out.println(list);
                        Type fooType = new TypeToken<ArrayList<ReportCard>>() {}.getType();
                        soos.writeObject(gson.toJson(list, fooType));
                        break;
                    }
                    case "FSalaryOverview": {
                        history.add(choice);
                        System.out.println("Обзор зарплаты работников(VBox)...");
                        FinalSalarySQL dao = new FinalSalaryDAO();
                        ArrayList<FinalSalary> list = dao.GetSalaryList();
                        System.out.println(list);
                        Type fooType = new TypeToken<ArrayList<FinalSalary>>() {}.getType();
                        soos.writeObject(gson.toJson(list, fooType));
                        break;
                    }
                    case "RoleChart": {
                        history.add(choice);
                        System.out.println("График соотношения пользователей и их ролей...");
                        RoleSQL dao = new RoleDAO();
                        role.setURole("Admin");
                        int count = dao.CountCol(role);
                        String Scount = String.valueOf(count);
                        soos.writeObject(Scount);
                        role.setURole("HR");
                        count = dao.CountCol(role);
                        Scount = String.valueOf(count);
                        soos.writeObject(Scount);
                        role.setURole("Encounter");
                        count = dao.CountCol(role);
                        Scount = String.valueOf(count);
                        soos.writeObject(Scount);
                        role.setURole("Worker");
                        count = dao.CountCol(role);
                        Scount = String.valueOf(count);
                        soos.writeObject(Scount);
                        break;
                    }
                    case "SalaryCalculation": {
                        history.add(choice);
                        double calculated;
                        System.out.println("Расчет зарплаты пошёл...");
                        String message = sois.readObject().toString();
                        Person person = gson.fromJson(message, Person.class);
                        staffing.setIdStaffing(person.getID());
                        reportCard.setRCID(person.getID());
                        finalSalary.setIdFS(person.getID());
                        staffingSQL dao = new staffingDAO();
                        ReportCardSQL dao1 = new ReportCardDAO();
                        FinalSalarySQL dao2 = new FinalSalaryDAO();
                        staffing = dao.getCasing(staffing);
                        reportCard = dao1.getDaysWorked(reportCard);
                        System.out.println(staffing.getCasing());
                        calculated = staffing.getCasing()-(0.13*staffing.getCasing())-(0.01*staffing.getCasing());
                        finalSalary.setFS(calculated);
                        System.out.println(finalSalary.getIdFS());
                        dao2.updateSalary(finalSalary);
                        soos.writeObject(gson.toJson(finalSalary));
                        break;
                    }
                    case "SalaryCalculation1": {
                        history.add(choice);
                        double calculated;
                        System.out.println("Расчет зарплаты пошёл...");
                        String message = sois.readObject().toString();
                        Person person = gson.fromJson(message, Person.class);
                        staffing.setIdStaffing(person.getID());
                        reportCard.setRCID(person.getID());
                        finalSalary.setIdFS(person.getID());
                        staffingSQL dao = new staffingDAO();
                        ReportCardSQL dao1 = new ReportCardDAO();
                        FinalSalarySQL dao2 = new FinalSalaryDAO();
                        staffing = dao.getCasing(staffing);
                        reportCard = dao1.getDaysWorked(reportCard);
                        System.out.println(staffing.getCasing());
                        calculated = (staffing.getCasing()-20)-(0.13*staffing.getCasing())-(0.01*staffing.getCasing());
                        finalSalary.setFS(calculated);
                        System.out.println(finalSalary.getIdFS());
                        dao2.updateSalary(finalSalary);
                        soos.writeObject(gson.toJson(finalSalary));
                        break;
                    }
                    case "SalaryCalculationOverview": {
                        history.add(choice);
                        System.out.println("Обзор работников(VBox)...");
                        FinalModelSQL dao = new FinalModelDAO();
                        ArrayList<FinalModel> list = dao.getSALARY();
                        System.out.println(list);
                        Type fooType = new TypeToken<ArrayList<FinalModel>>() {}.getType();
                        soos.writeObject(gson.toJson(list, fooType));
                        break;
                    }
                    case "FileWriter": {
                        FinalModelSQL dao = new FinalModelDAO();
                        String message = sois.readObject().toString();
                        finalModel = gson.fromJson(message, FinalModel.class);

                        FinalModel list = dao.saveSalaryToFile(finalModel);

                        if (list.getRole().equals(""))
                            soos.writeObject("There is no data!");
                        else {

                            BufferedWriter outputWriter = null;
                            outputWriter = new BufferedWriter(new FileWriter("payment order"));
                            //outputWriter.write("Оценённые объекты:\n");
                            //for (FinalModel s : list) {
                                outputWriter.write(list.getName() + list.getSurname() + list.getRole() + list.getSalary() + list.getDaysWorked() + list.getTaxes());
                                outputWriter.newLine();
                            //}
                            outputWriter.flush();
                            outputWriter.close();

                        }
                    }
                    case "History": {
                        System.out.println("История действий пользователя...");
                        Type fooType = new TypeToken<ArrayList<String>>() {}.getType();
                        soos.writeObject(gson.toJson(history, fooType));
                        history.add(choice);
                        break;
                    }
                    case "UpdateRole": {
                        System.out.println("Изменение роли...");
                        String message = sois.readObject().toString();
                        role = gson.fromJson(message, Role.class);
                        RoleSQL dao = new RoleDAO();
                        dao.updateRole(role);
                        role = dao.getRole(role);
                        taxes.setPersonID(role.getPersonID());
                        TaxesSQL TaxesDao = new TaxesDAO();
                        staffingSQL stdao = new staffingDAO();
                        FinalSalarySQL fsdao = new FinalSalaryDAO();
                        staffing.setPersonID(taxes.getPersonID());
                        finalSalary.setPersonID(taxes.getPersonID());
                        staffing = stdao.getCasing(staffing);
                        System.out.println(staffing.getCasing());
                        finalSalary = fsdao.getFinalSalary(finalSalary);
                        System.out.println(finalSalary.getFS());
                        System.out.println(taxes.getUserTaxes());
                        taxes.setUserTaxes((int) (staffing.getCasing() - finalSalary.getFS()));
                        System.out.println(taxes.getUserTaxes());
                        TaxesDao.updateTaxes(taxes);
                        if(role.getPersonID() != 0) {
                            //soos.writeObject(gson.toJson(role));
                        } //else { soos.writeObject("There is no data!"); }
                        history.add(choice);
                        break;
                    }
                    case "SearchById": {
                        history.add(choice);
                        System.out.println("ПОиск по ID...");
                        String message = sois.readObject().toString();
                        finalModel = gson.fromJson(message, FinalModel.class);
                        FinalModelSQL dao = new FinalModelDAO();
                        ArrayList<FinalModel> list  = dao.SearchByID(finalModel);
                        System.out.println(finalModel);
                        //if(finalModel.getRole().equals("")) {
                            //soos.write"There is no data!");
                       // }
                       // else {
                            Type fooType = new TypeToken<ArrayList<FinalModel>>() {
                            }.getType();
                            soos.writeObject(gson.toJson(list, fooType));
                       // }
                        break;
                    }
                    case "ClearHistory": {
                        history.clear();
                        break;
                    }
                    default: {
                        System.out.println("че?!");
                        break;
                    }
                }
            }
        }  catch (IOException | ClassNotFoundException e) {
            System.out.println("Client disconnected with error.");
        }
    }
}
