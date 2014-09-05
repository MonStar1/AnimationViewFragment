package animviewfragment.android.epam.com.animationviewfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends Fragment {

    public static SecondFragment newInstance(Bundle args) {
        SecondFragment fr = new SecondFragment();
        if (args == null) {
            args = new Bundle();
        }
        fr.setArguments(args);
        return fr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.second_fragment, container, false);
        Bundle bundle = getArguments();

        SerializableView remoteSquare = (SerializableView) bundle.getSerializable(FirstFragment.EXTRA_SQUARE_VIEW);
        if(remoteSquare != null) {
            UIUtil.moveView(rootView, remoteSquare);
        }
        SerializableView remoteLine = (SerializableView) bundle.getSerializable(FirstFragment.EXTRA_LINE_VIEW);
        if (remoteLine != null) {
            UIUtil.moveView(rootView, remoteLine);
        }


        rootView.findViewById(R.id.header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                View square = getView().findViewById(R.id.header);
                SerializableView serializableSquareView = SerializableView.create(square);
                bundle.putSerializable(FirstFragment.EXTRA_SQUARE_VIEW, serializableSquareView);

                View line = getView().findViewById(R.id.green);
                SerializableView serializableLineView = SerializableView.create(line);
                bundle.putSerializable(FirstFragment.EXTRA_LINE_VIEW, serializableLineView);


                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.container, FirstFragment.newInstance(bundle))
                        .commit();
            }
        });

        return rootView;
    }

}
