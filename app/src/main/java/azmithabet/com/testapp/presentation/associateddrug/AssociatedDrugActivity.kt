package azmithabet.com.testapp.presentation.associateddrug

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import azmithabet.com.testapp.R
import azmithabet.com.testapp.data.model.AssociatedDrug
import azmithabet.com.testapp.databinding.ActivityAssociatedDrugBinding
import azmithabet.com.testapp.databinding.DrugDetailsBinding
import azmithabet.com.testapp.presentation.App
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import javax.inject.Inject
import android.R.attr.onClick
import android.view.View


class AssociatedDrugActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAssociatedDrugBinding
    private lateinit var sheetBinding: DrugDetailsBinding
    private lateinit var sheetDialog: BottomSheetDialog
    @Inject
    lateinit var factory: AssociatedDrugViewModelFactory

    private lateinit var viewModel: AssociatedDrugViewModel

    private lateinit var associatedDrugsAdapter: AssociatedDrugsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_associated_drug)

        initialization()

        binding.update.setOnClickListener {
           updateData()
        }

        viewModel.getGreetingMessage().observe(this, {
            showGreetingDialog(it)
        })

        viewModel.getAssociatedDrugs().observe(this, {
            if (it != null)
                associatedDrugsAdapter.setList(it)
            binding.progressBar.visibility=GONE
        })
    }

    private fun initialization() {
        (application as App).createAssociatedDrugSubComponent().inject(this)

        viewModel = ViewModelProvider(this, factory).get(AssociatedDrugViewModel::class.java)
        associatedDrugsAdapter = AssociatedDrugsAdapter { associatedDrug -> itemClick(associatedDrug) }

        binding.recycler.adapter = associatedDrugsAdapter
        binding.recycler.layoutManager = LinearLayoutManager(this)

        //dialog sheet
        val mSheetDialog = layoutInflater.inflate(R.layout.drug_details, null)
        sheetBinding = DrugDetailsBinding.inflate(layoutInflater, mSheetDialog as ViewGroup, false)
        sheetDialog = BottomSheetDialog(this,R.style.SheetDialog)
        sheetDialog.setContentView(sheetBinding.root)

    }

    private fun updateData() {
        binding.progressBar.visibility= VISIBLE
        associatedDrugsAdapter.setList(ArrayList())
        viewModel.updateAssociatedDrugs().observe(this,{
            if (it != null)
                associatedDrugsAdapter.setList(it)
            binding.progressBar.visibility=GONE
        })
    }

    private fun showGreetingDialog(greetingMessage: Int?) {
        val userName: String = intent.extras!!.getString("user_name", "")
        val message = resources.getString(greetingMessage!!) + " " + userName
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.welcome))
            .setMessage(message)
            .show()
    }

    private fun itemClick(associatedDrug: AssociatedDrug)
    {
        sheetBinding.associatedDrug=associatedDrug
        sheetDialog.show()
    }
}