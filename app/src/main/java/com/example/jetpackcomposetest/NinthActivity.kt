package com.example.jetpackcomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// State compose는 State기반이다.
class NinthActivity : ComponentActivity() {
    private val viewModel by viewModels<TestViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen(viewModel)
        }
    }
}

@Composable
fun HomeScreen(viewModel: TestViewModel) {
    // 상수선언 할당되고 수정되지 않음 기본
    val test1: MutableState<String> = remember {
        mutableStateOf("th1")
    }

    // 변수선언 딜리게이트 get, set 간단한 저장 용도 해당 방법이 편하다
    var test2: String by remember {
        mutableStateOf("th2")
    }

    // setText로 변경 텍스트필드(editText) 사용시 해당 방법이 편하다
    val (test: String, setText: (String) -> Unit) = remember {
        mutableStateOf("th3")
    }

    val test3: State<String> = viewModel.liveData.observeAsState("th4")

    Column {
        Text(text = "hello")
        Button(onClick = {
            test1.value = "변경"
            test2 = "변경"
            viewModel.testChangeValue()
            viewModel.updateLiveData("변경")
        }) {
            Text(text = "클릭")
        }
        TextField(value = test, onValueChange = setText)
        Text(text = test1.value)
        Text(text = test2)
        Text(text = viewModel.value.value)
        Text(text = test3.value)
    }
}

class TestViewModel: ViewModel() {
    private val _value = mutableStateOf("th")
    val value: State<String> = _value

    fun testChangeValue() {
        _value.value = "변경"
    }

    // 라이브데이터 state변환 가능
    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    fun updateLiveData(newValue: String) {
        _liveData.value = newValue
    }
}

