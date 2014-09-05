package animviewfragment.android.epam.com.animationviewfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {

    public static final String EXTRA_SQUARE_VIEW = "extra_square_view";
    public static final String EXTRA_LINE_VIEW = "extra_line_view";

    public static FirstFragment newInstance(Bundle args) {
        FirstFragment fr = new FirstFragment();
        if (args == null) {
            args = new Bundle();
        }
        fr.setArguments(args);
        return fr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Bundle bundle = getArguments();
        if(bundle != null) {
            SerializableView remoteSquare = (SerializableView) bundle.getSerializable(FirstFragment.EXTRA_SQUARE_VIEW);
            if (remoteSquare != null) {
                UIUtil.moveView(rootView, remoteSquare);
            }
            SerializableView remoteLine = (SerializableView) bundle.getSerializable(FirstFragment.EXTRA_LINE_VIEW);
            if (remoteLine != null) {
                UIUtil.moveView(rootView, remoteLine);
            }
        }


        rootView.findViewById(R.id.header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                View square = getView().findViewById(R.id.header);
                SerializableView serializableSquareView = SerializableView.create(square);
                bundle.putSerializable(EXTRA_SQUARE_VIEW, serializableSquareView);

                View line = getView().findViewById(R.id.green);
                SerializableView serializableLineView = SerializableView.create(line);
                bundle.putSerializable(EXTRA_LINE_VIEW, serializableLineView);


                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.container, SecondFragment.newInstance(bundle))
                        .commit();
            }
        });
        return rootView;
    }
}
