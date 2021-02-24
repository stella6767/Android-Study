# Android-Retrofit2-MovieApp-V1-Design

![녹화_2021_02_24_16_49_38_403](https://user-images.githubusercontent.com/65489223/108966836-0d12c900-76c2-11eb-9872-6aa87354e696.gif)


#### 1. Gradle
```gradle
 implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'

    implementation 'com.squareup.picasso:picasso:2.5.2'
    implementation 'com.squareup.retrofit2:retrofit:2.1.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.1.0'
    implementation 'androidx.recyclerview:recyclerview:1.1.0'

    implementation 'com.google.android.material:material:1.2.0-alpha02'
    implementation 'com.makeramen:roundedimageview:2.3.0'
    compileOnly 'org.projectlombok:lombok:1.18.10'
    annotationProcessor 'org.projectlombok:lombok:1.18.10'

    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'

    def lifecycle_version = "2.2.0";
    implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
```

#### 2. 데이터바인딩 사용법
<https://gogorchg.tistory.com/entry/AndroidDataBinding-ImageView-src%EC%97%90-%EC%97%B0%EB%8F%99-%ED%95%98%EA%B8%B0-%ED%95%A8%EC%88%98-%EC%97%B0%EA%B2%B0>
```
            app:mediumCoverImage ="@{movie.mediumCoverImage}"
```

#### 3. 스프링서버





