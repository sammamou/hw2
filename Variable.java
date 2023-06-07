df_with_dangerous_plane = df[df["type"].isin(most_dangerous_plane["type"])]
dangerous_operator_liste = df_with_dangerous_plane["operator"].unique()
df_with_dangerous_operator = df[df["operator"].isin(dangerous_operator_liste)].sort_values("operator").reset_index().drop("index", axis =1)
most_dangerous_operator = df_with_dangerous_operator.groupby("operator").agg(number_accident = ("cat", "count")).reset_index().sort_values("number_accident", ascending = False).head(3)
dangerous_operator_graph = sns.catplot(x="operator", y="number_accident", kind="bar", data=most_dangerous_operator);
dangerous_operator_graph.fig.suptitle('3 most dangerous operators')
