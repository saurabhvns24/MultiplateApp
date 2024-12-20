package com.example.imageproject

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters

class ImagePrefetchWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val repository: ImageRepository
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        val urls = inputData.getStringArray("urls") ?: return Result.failure()

        urls.forEach { url ->
            repository.getImage(url) // Caching the images
        }
        return Result.success()
    }


}
fun prefetchImages(context: Context, urls: List<String>) {
    val workData = Data.Builder().putStringArray("urls", urls.toTypedArray()).build()
    val workRequest = OneTimeWorkRequestBuilder<ImagePrefetchWorker>()
        .setInputData(workData)
        .build()

    WorkManager.getInstance(context).enqueue(workRequest)
}
