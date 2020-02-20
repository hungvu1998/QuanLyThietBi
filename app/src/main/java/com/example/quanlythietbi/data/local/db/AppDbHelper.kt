package com.example.quanlythietbi.data.local.db

import io.reactivex.Observable
import java.util.concurrent.Callable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDbHelper @Inject
constructor(private val mAppDatabase: AppDatabase) : DbHelper {

//    val allQuestions: Observable<List<Question>>
//        get() = mAppDatabase.questionDao().loadAll()
//            .toObservable()
//
//    val allUsers: Observable<List<User>>
//        get() = Observable.fromCallable<List<User>> { mAppDatabase.userDao().loadAll() }
//
//    val isOptionEmpty: Observable<Boolean>
//        get() = mAppDatabase.optionDao().loadAll()
//            .flatMapObservable({ options -> Observable.just(options.isEmpty()) })
//
//    val isQuestionEmpty: Observable<Boolean>
//        get() = mAppDatabase.questionDao().loadAll()
//            .flatMapObservable({ questions -> Observable.just(questions.isEmpty()) })
//
//    fun getOptionsForQuestionId(questionId: Long?): Observable<List<Option>> {
//        return mAppDatabase.optionDao().loadAllByQuestionId(questionId)
//            .toObservable()
//    }
//
//    fun insertUser(user: User): Observable<Boolean> {
//        return Observable.fromCallable {
//            mAppDatabase.userDao().insert(user)
//            true
//        }
//    }
//
//    fun saveOption(option: Option): Observable<Boolean> {
//        return Observable.fromCallable {
//            mAppDatabase.optionDao().insert(option)
//            true
//        }
//    }
//
//    fun saveOptionList(optionList: List<Option>): Observable<Boolean> {
//        return Observable.fromCallable {
//            mAppDatabase.optionDao().insertAll(optionList)
//            true
//        }
//    }
//
//    fun saveQuestion(question: Question): Observable<Boolean> {
//        return Observable.fromCallable {
//            mAppDatabase.questionDao().insert(question)
//            true
//        }
//    }
//
//    fun saveQuestionList(questionList: List<Question>): Observable<Boolean> {
//        return Observable.fromCallable {
//            mAppDatabase.questionDao().insertAll(questionList)
//            true
//        }
//    }
}
