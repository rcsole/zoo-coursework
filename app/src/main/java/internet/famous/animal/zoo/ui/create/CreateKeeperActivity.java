package internet.famous.animal.zoo.ui.create;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;

import internet.famous.animal.zoo.R;
import internet.famous.animal.zoo.data.local.Keeper;
import internet.famous.animal.zoo.databinding.ActivityCreateKeeperBinding;

public final class CreateKeeperActivity
    extends BaseCreateActivity<Keeper, ActivityCreateKeeperBinding> {
  private static final int MINIMUM_NAME_LENGTH = 3;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding.editTextKeeperName.addTextChangedListener(
        new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            data.name = binding.editTextKeeperName.getText().toString();
            binding.saveButton.setEnabled(data.name.length() >= MINIMUM_NAME_LENGTH);
          }

          @Override
          public void afterTextChanged(Editable s) {}
        });
    binding.saveButton.setOnClickListener(this::onSaveBtnClicked);
  }

  @Override
  public int getLayoutRes() {
    return R.layout.activity_create_keeper;
  }
}
